<template>
    <div>
        <el-container>
    <el-main>

        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">管理中心</el-breadcrumb-item>
            <el-breadcrumb-item>职务权限</el-breadcrumb-item>
        </el-breadcrumb>

        <div style="margin: 10px 0;">
            <el-input style="width: 200px;" placeholder="请输入职务名称" suffix-icon="el-icon-search" v-model="name"></el-input>
            <el-button type="primary" style="margin-left: 5px;" @click="load">搜索</el-button>
            <el-button type="warning" @click="reset">重置</el-button>
        </div>

        <div style="margin: 10px 0;">
            <el-button type="primary" @click="handleAdd">新增职务<i class="el-icon-circle-plus-outline"></i></el-button>
            <el-button type="primary">导入<i class="el-icon-bottom"></i></el-button>
            <el-button type="primary">导出<i class="el-icon-top"></i></el-button>
        </div>

        <el-table :data="tableData" border stripe @selection-change="handleSelectionChange"> 
            <!-- <el-table-column type="selection" width="55"></el-table-column> -->
            <!-- <el-table-column prop="id" label="Id" width="120"></el-table-column> -->
            <el-table-column prop="name" label="职务名称" width="120"></el-table-column>
            <el-table-column prop="num" label="成员数量" width="120"></el-table-column>
            <el-table-column prop="descri" label="权限描述" width="120"></el-table-column>
            <el-table-column prop="time" label="更新时间" width="150"></el-table-column>
            <el-table-column lable="操作" >
                <template slot-scope="scope">
                    <el-button type="success" @click="handleEdit(scope.row)">添加人员<i class="el-icon-edit"></i></el-button>
                    <el-button type="success" @click="handleEdit(scope.row)">编辑职务<i class="el-icon-edit"></i></el-button>
                    <el-popconfirm
                        style="margin-left: 5px;"
                        confirm-button-text="确定"
                        cancel-button-text="我再想想"
                        icon="el-icon-info"
                        icon-color="red"
                        title="你确定吗？"
                        @confirm="handleDelete(scope.row.id)">
                        <el-button type="danger" slot="reference">删除职务<i class="el-icon-remove-outline"></i></el-button>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>
        <div style="padding: 10px 0;">
            <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="pageNum"
                :page-sizes="[2, 5, 10, 20]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
            </el-pagination>
        </div>

        <el-dialog title="职务权限信息" :visible.sync="dialogFormVisible" width="30%">
        <el-form label-width="80px" size="small">
            <el-form-item label="职务名称">
                <el-input v-model="form.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="成员数量">
                <el-input v-model="form.num" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="权限描述">
                <el-input v-model="form.descri" autocomplete="off"></el-input>
            </el-form-item>    
            <el-form-item label="更新时间">
                <el-input v-model="form.time" autocomplete="off"></el-input>
            </el-form-item>       
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="save">确 定</el-button>
        </div>
        </el-dialog>
    </el-main>
  </el-container>

    </div>
</template>
<script>
export default {
    data() {
        return {
            tableData:[],
            total:0,
            pageNum:1,
            pageSize:2,
            name:"",
            form:{},
            dialogFormVisible:false,
            multipleSelection:[]
        }
    },
    created() {
        this.load()
    },
    methods: {
        load() {
            this.request.get("http://localhost:9090/permissions/page",{
                params: {
                    pageNum: this.pageNum,
                    pageSize: this.pageSize,
                    name: this.name,
                }
                }).then(res => {
                console.log(res)

                this.tableData = res.data
                this.total = res.total
            })
        },
        reset(){
            this.name=""
            this.load()
        },
        save() {
            this.request.post("/permissions",this.form).then(res => {
                if(res) {
                    this.$message.success("新增成功")
                    this.dialogFormVisible = false
                    this.load()
                }else {
                    this.$message.error("新增失败")
                }
            })
        },
        handleAdd() {
            this.dialogFormVisible = true
            this.form = {}
        },
        handleSelectionChange(val) {
            this.multipleSelection = val
        },
        handleEdit(row) {
            this.form = Object.assign({},row)
            this.dialogFormVisible = true
        },
        handleDelete(id) {
            this.request.delete("/permissions/" + id).then(res => {
                if(res) {
                    this.$message.success("删除成功")
                    this.load()
                }else {
                    this.$message.error("删除失败")
                }
            })
        },
        handleSizeChange(pageSize) {
            console.log(pageSize)
            this.pageSize = pageSize
            this.load()
        },
        handleCurrentChange(pageNum) {
            console.log(pageNum)
            this.pageNum = pageNum
            this.load()
        }
    }
}
</script>