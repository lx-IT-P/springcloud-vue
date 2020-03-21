package com.leyou.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.MemberMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.TbMemberLevel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author: liuxiang
 * @Date: 2020/3/21
 * @Description:会员管理
 */
@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    /**
     * 分页查询
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    public PageResult<TbMemberLevel> queryMemberByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(TbMemberLevel.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria()
                    .andLike("name", "%" + key + "%")
                    .orEqualTo("memberLevel", key)
                    .orEqualTo("sex", key)
                    .orEqualTo("age", key);
        }
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        Page<TbMemberLevel> pageInfo = (Page<TbMemberLevel>) memberMapper.selectByExample(example);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo);
    }

    /**
     * 根据id查询会员信息
     * @param id
     * @return
     */
    public TbMemberLevel queryById(Long id) {
        TbMemberLevel memberLevel = memberMapper.selectByPrimaryKey(id);
        if (memberLevel == null) {
            throw new LyException(ExceptionEnum.MEMBER_NOT_FOUND);
        }
        return memberLevel;
    }

    /**
     * 编辑会员信息
     * @param tbMemberLevel
     * @return
     */
    public int editMember(TbMemberLevel tbMemberLevel) {
        return memberMapper.updateByPrimaryKey(tbMemberLevel);
    }

    /**
     * 删除会员信息
     * @param id
     * @return
     */
    public int deleteMemberById(Long id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    /**
     * 新增会员信息
     * @param tbMemberLevel
     */
    public void saveMember(TbMemberLevel tbMemberLevel) {
       // tbMemberLevel.setId(null);
        int count = memberMapper.insert(tbMemberLevel);
        if (count != 1) {
            throw new LyException(ExceptionEnum.MEMBER_SAVE_ERROR);
        }
    }
    }