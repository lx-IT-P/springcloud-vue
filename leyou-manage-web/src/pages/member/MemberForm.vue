<template>
  <v-form v-model="valid" ref="myMemberForm">
    <v-text-field v-model="member.name" label="请输入会员名称" required/>
    <v-text-field v-model="member.age" label="请输入会员年龄" required />
    <v-text-field v-model="member.sex" label="请输入性别" required />
    <v-text-field v-model="member.score" label="请输入会员积分" required />
    <v-text-field v-model="member.consumeMoney" label="请输入消费额" required />
    <v-text-field v-model="member.memberLevel" label="请输入会员等级" required/>


    <v-layout class="my-4" row>
      <v-spacer/>
      <v-btn @click="submit" color="primary">提交</v-btn>
      <v-btn @click="clear">重置</v-btn>
    </v-layout>
  </v-form>

</template>

<script>
  export default {
    name: "member-form",
    props: {
      oldMember: {
        type: Object
      },
      isEdit: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        valid: false, // 表单校验结果标记
        member: {
          name: '', // 会员名称
          sex: '', // 会员性别
          age: '',// 会员年龄
          consumeMoney: '', // 消费额
          score: '',// 会员积分
          memberLevel: '', // 会员等级
        },
      }
    },
    methods: {
      submit() {
        // 表单校验
        if (this.$refs.myMemberForm.validate()) {
          // 定义一个请求参数对象，通过解构表达式来获取brand中的属性
          const { ...params} = this.member;
          // 将数据提交到后台
          // this.$http.post('/item/brand', this.$qs.stringify(params))
          this.$http({
            method: this.isEdit ? 'put' : 'post',
            url: '/item/member/update',
            data: this.$qs.stringify(params)
          }).then(() => {
            // 关闭窗口
            this.$emit("close");
            this.$message.success("保存成功！");
          })
            .catch(() => {
              this.$message.error("保存失败！");
            });
        }
      },
      clear() {
        // 重置表单
        this.$refs.myMemberForm.reset();

      }
    },
    watch: {
      oldMember: {// 监控oldBrand的变化
        handler(val) {
          if (val) {
            // 注意不要直接复制，否则这边的修改会影响到父组件的数据，copy属性即可
            this.member = Object.deepCopy(val)
          } else {
            // 为空，初始化brand
            this.member = {
              name: '', // 会员名称
              sex: '', // 会员性别
              age: '',// 会员年龄
              consumeMoney: '', // 消费额
              score: '',// 会员积分
              memberLevel: '', // 会员等级
            }
          }
        },
        deep: true
      }
    }
  }
</script>

<style scoped>

</style>
