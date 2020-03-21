package com.leyou.item.web;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.TbMemberLevel;
import com.leyou.item.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: liuxiang
 * @Date: 2020/3/21
 * @Description:会员管理处理类
 */
@RestController
@RequestMapping("member")
public class MemberController {
    /**
     * service依赖注入
     */
    @Autowired
    private MemberService memberService;
    /**
     * 分页查询品牌
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<TbMemberLevel>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {
        PageResult<TbMemberLevel> result = memberService.queryMemberByPageAndSort(page,rows,sortBy,desc, key);
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 根据id查询会员
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<TbMemberLevel> queryBrandById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(memberService.queryById(id));
    }

    /**
     * 根据id编辑会员信息
     * @param tbMemberLevel
     * @return
     */
    @PutMapping("update")
    public ResponseEntity<Integer> editMember(TbMemberLevel tbMemberLevel){
        return ResponseEntity.ok(memberService.editMember(tbMemberLevel));
    }

    /**
     * 根据id删除会员信息
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    public ResponseEntity<Integer> deleteMemberById(@PathVariable("id") Long id){
        return ResponseEntity.ok(memberService.deleteMemberById(id));
    }

    /**
     * 新增会员信息
     * @param tbMemberLevel
     * @return
     */
    @PostMapping("update")  // 传入 "1,2,3"的字符串可以解析为列表
    public ResponseEntity<Void> saveBrand(TbMemberLevel tbMemberLevel) {
        memberService.saveMember(tbMemberLevel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
