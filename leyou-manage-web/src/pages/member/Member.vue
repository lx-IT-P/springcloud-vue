<template>
  <v-card>
    <v-card-title>
      <v-btn color="primary" @click="addMember">新增会员</v-btn>
      <!--搜索框，与search属性关联-->
      <v-spacer/>
      <v-flex xs3>
      <v-text-field label="输入关键字搜索" v-model.lazy="search" append-icon="search" hide-details/>
      </v-flex>
    </v-card-title>
    <v-divider/>
    <v-data-table
      :headers="headers"
      :items="brands"
      :pagination.sync="pagination"
      :total-items="totalBrands"
      :loading="loading"
      class="elevation-1"
    >
      <template slot="items" slot-scope="props">
        <td class="text-xs-center">{{ props.item.id }}</td>
        <td class="text-xs-center">{{ props.item.name }}</td>
        <td class="text-xs-center">{{ props.item.sex }}</td>
        <td class="text-xs-center">{{ props.item.score }}</td>
        <td class="text-xs-center">{{ props.item.memberLevel }}</td>
        <td class="text-xs-center">{{ props.item.consumeMoney }}</td>
        <td class="text-xs-center">{{ props.item.age }}</td>
        <td class="justify-center layout px-0">
          <v-btn icon @click="editMember(props.item)">
            <i class="el-icon-edit"/>
          </v-btn>
          <v-btn icon @click="deleteMember(props.item)">
            <i class="el-icon-delete"/>
          </v-btn>
        </td>
      </template>
    </v-data-table>
    <!--弹出的对话框-->
    <v-dialog max-width="500" v-model="show" persistent scrollable>
      <v-card>
        <!--对话框的标题-->
        <v-toolbar dense dark color="primary">
          <v-toolbar-title>{{isEdit ? '修改' : '新增'}}会员</v-toolbar-title>
          <v-spacer/>
          <!--关闭窗口的按钮-->
          <v-btn icon @click="closeWindow"><v-icon>close</v-icon></v-btn>
        </v-toolbar>
        <!--对话框的内容，表单-->
        <v-card-text class="px-5" style="height:400px">
          <member-form @close="closeWindow" :oldMember="oldMember" :isEdit="isEdit"></member-form>
        </v-card-text>
      </v-card>
    </v-dialog>
  </v-card>
</template>

<script>
  // 导入自定义的表单组件
  import MemberForm from './MemberForm'
  import id from "element-ui/src/locale/lang/id";

  export default {
    name: "member",
    data() {
      return {
        search: '', // 搜索过滤字段
        totalBrands: 0, // 总条数
        brands: [], // 当前页品牌数据
        loading: true, // 是否在加载中
        pagination: {}, // 分页信息
        headers: [
          {text: 'id', align: 'center', value: 'id'},
          {text: '会员姓名', align: 'center', sortable: false, value: 'name'},
          {text: '会员性别', align: 'center', sortable: false, value: 'sex'},
          {text: '会员积分', align: 'center', value: 'score', sortable: true},
          {text: '会员等级', align: 'center', value: 'memberLevel', sortable: true,},
          {text: '会员消费额', align: 'center', sortable: true, value: 'consumeMoney'},
          {text: '会员年龄', align: 'center', sortable: true, value: 'age'},
          {text: '操作', align: 'center', value: 'id', sortable: false}
        ],
        show: false,// 控制对话框的显示
        oldMember: {}, // 即将被编辑的品牌数据
        isEdit: false, // 是否是编辑
      }
    },
    mounted() { // 渲染后执行
      // 查询数据
      this.getDataFromServer();
    },
    watch: {
      pagination: { // 监视pagination属性的变化
        deep: true, // deep为true，会监视pagination的属性及属性中的对象属性变化
        handler() {
          // 变化后的回调函数，这里我们再次调用getDataFromServer即可
          this.getDataFromServer();
        }
      },
      search: { // 监视搜索字段
        handler() {
          this.getDataFromServer();
        }
      }
    },
    methods: {
      getDataFromServer() { // 从服务的加载数的方法。
        // 发起请求
        this.$http.get("/item/member/page", {
          params: {
            key: this.search, // 搜索条件
            page: this.pagination.page,// 当前页
            rows: this.pagination.rowsPerPage,// 每页大小
            sortBy: this.pagination.sortBy,// 排序字段
            desc: this.pagination.descending// 是否降序
          }
        }).then(resp => { // 这里使用箭头函数
          this.brands = resp.data.items;
          this.totalBrands = resp.data.total;
          // 完成赋值后，把加载状态赋值为false
          this.loading = false;
        })
      },
      addMember() {
        // 修改标记
        this.isEdit = false;
        // 控制弹窗可见：
        this.show = true;
        // 把oldMember变为null
        this.oldMember = null;
      },
      editMember(oldMember){
        // 根据品牌信息查询商品分类
        this.$http.get("/item/member/" + oldMember.id)
          .then(({data}) => {
            // 修改标记
            this.isEdit = true;
            // 控制弹窗可见：
            this.show = true;
            // 获取要编辑的brand
            this.oldMember = oldMember
          })
      },
      deleteMember(oldMember){
        this.$message.confirm('此操作将永久删除数据，是否继续?', '提示', {
          confirmButtonText: '确定删除',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
        // 根据品牌信息查询商品分类
        this.$http.get("/item/member/delete/" + oldMember.id)
          .then(({data}) => {
            // 完成赋值后，把加载状态赋值为false
            this.getDataFromServer();
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      closeWindow(){
        // 重新加载数据
        this.getDataFromServer();
        // 关闭窗口
        this.show = false;
      }
    },
    components:{
        MemberForm
    }
  }
</script>

<style scoped>

</style>
