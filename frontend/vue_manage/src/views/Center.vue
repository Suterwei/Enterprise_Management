<template>
    <div>
        <el-card>
            <div class="box">
                <div class="part1"> 
                        <img class="d2" src="../assets/images/img1.png" alt="">
                        <span class="d3">Lucky7，欢迎进入系统管理中心！</span><br>
                        <span class="d4">上次登录：2023年7月9日 星期日 10：32：16</span>
                        <span class="d5">员工数量</span>
                        <span class="d6">产品数量</span>
                        <span class="d7">在线用户</span>
                        <span class="d8">100</span>
                        <span class="d9">100</span>
                        <span class="d10">100</span>
                </div>
                <div class="part2" style="position: relative;left: 100px;">     
                    <el-row :gutter="16" style="margin-top:10px;">
                        <el-col :span="4">
                            <el-card style="height: 100px; cursor:pointer" @click.native="clickMenu1()">
                                <div class="i1">
                                    <i class="el-icon-tickets"></i><br>
                                </div>
                                <div class="p1">企业设置</div>
                            </el-card>
                        </el-col>
                        <el-col :span="4">
                            <el-card style="height: 100px; cursor:pointer" @click.native="clickMenu2()">
                                <div class="i1">
                                    <i class="el-icon-tickets"></i><br>
                                </div>
                                <div class="p1">组织架构</div>
                            </el-card>
                        </el-col>
                        <el-col :span="4">
                            <el-card style="height: 100px; cursor:pointer" @click.native="clickMenu3()">
                                <div class="i1">
                                    <i class="el-icon-s-custom"></i><br>
                                </div>
                                <div class="p1">职务权限</div>
                            </el-card>
                        </el-col>
                        <el-col :span="4">
                            <el-card style="height: 100px; cursor:pointer" @click.native="clickMenu4()">
                                <div class="i1">
                                    <i class="el-icon-user"></i><br>
                                </div>
                                <div class="p1">员工管理</div>
                            </el-card>
                        </el-col>
                        <el-col :span="4">
                            <el-card style="height: 100px; cursor:pointer" @click.native="clickMenu5()">
                                <div class="i1">
                                    <i class="el-icon-s-grid"></i><br>
                                </div>
                                <div class="p1">模块管理</div>
                            </el-card>
                        </el-col>
                    </el-row>
                    <el-row :gutter="16" style="margin-top:10px;">
                        <el-col :span="4">
                            <el-card style="height: 100px; cursor:pointer" @click.native="clickMenu6()">
                                <div class="i1">
                                    <i class="el-icon-box"></i><br>
                                </div>
                                <div class="p1">产品管理</div>
                            </el-card>
                        </el-col>
                        <el-col :span="4">
                            <el-card style="height: 100px; cursor:pointer" @click.native="clickMenu7()">
                                <div class="i1">
                                    <i class="el-icon-edit-outline"></i><br>
                                </div>
                                <div class="p1">业务设置</div>
                            </el-card>
                        </el-col>
                        <el-col :span="4">
                            <el-card style="height: 100px; cursor:pointer" @click.native="clickMenu8()">
                                <div class="i1">
                                    <i class="el-icon-notebook-2"></i><br>
                                </div>
                                <div class="p1">字段设置</div>
                            </el-card>
                        </el-col>
                        <el-col :span="4">
                            <el-card style="height: 100px; cursor:pointer" @click.native="clickMenu9()">
                                <div class="i1">
                                    <i class="el-icon-s-management"></i><br>
                                </div>
                                <div class="p1">字典管理</div>
                            </el-card>
                        </el-col>
                        <el-col :span="4">
                            <el-card style="height: 100px; cursor:pointer" @click.native="clickMenu10()">
                                <div class="i1">
                                    <i class="el-icon-date"></i><br>
                                </div>
                                <div class="p1">日志管理</div>
                            </el-card>
                        </el-col>
                    </el-row>
                    <!-- <el-card class="select1">
                        <div class="sel_11">
                            <i class="el-icon-tickets"></i><br>
                        </div>
                        <div class="sel_12">企业设置</div>
                    </el-card>
                    
                    <el-card class="select2">
                        <div class="sel_21">
                            <i class="el-icon-data-board"></i><br>
                        </div>
                        <div class="sel_22">组织架构</div>
                    </el-card>

                    <el-card class="select3">
                        <div class="sel_31">
                            <i class="el-icon-s-custom"></i><br>
                        </div>
                        <div class="sel_32">职务权限</div>
                    </el-card>

                    <el-card class="select4">
                        <div class="sel_41">
                            <i class="el-icon-s-custom"></i><br>
                        </div>
                        <div class="sel_42">员工管理</div>
                    </el-card> -->
                </div>

                <div class="part3" style="position: relative; top: 50px;left: 40px;">&emsp;
                    <div class="news">
                        <i class="el-icon-chat-dot-round" style="font-size: 30px;"></i><span>&nbsp;系统公告</span>
                    </div><br>
                    <el-button type="primary" @click="handleAdd">发布公告<i class="el-icon-circle-plus-outline"></i></el-button>
                    <br><br>
                    <el-table
                    :data="tableData"  border stripe
                    style="width: 100%"
                    @selection-change="handleSelectionChange">
                    <el-table-column
                        prop="title"
                        label="公告标题"
                        width="180">
                    </el-table-column>
                    <el-table-column
                        prop="name"
                        label="发布人员"
                        width="180">
                    </el-table-column>
                    <el-table-column
                        prop="ctime"
                        label="发布时间"
                        width="180">
                    </el-table-column>
                    <el-table-column
                        prop="category"
                        label="所属栏目"
                        width="180">
                    </el-table-column>
                    <el-table-column
                        prop="receiving"
                        label="接收人员"
                        width="180">
                    </el-table-column>
                    <el-table-column prop="act" lable="操作">
                    <template slot-scope="scope">
                        <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"></i></el-button>
                        <el-popconfirm
                            style="margin-left: 5px;"
                            confirm-button-text="确定"
                            cancel-button-text="我再想想"
                            icon="el-icon-info"
                            icon-color="red"
                            title="你确定吗？"
                            @confirm="handleDelete(scope.row.id)">
                            <el-button type="danger" slot="reference">删除<i class="el-icon-remove-outline"></i></el-button>
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
                    <el-dialog title="新增公告" :visible.sync="dialogFormVisible" width="30%">
                    <el-form label-width="80px" size="small">
                        <el-form-item label="公告标题">
                            <el-input v-model="form.title" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="发布人员">
                            <el-input v-model="form.name" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="发布时间">
                            <el-input v-model="form.ctime" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="所属栏目">
                            <el-input v-model="form.category" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item label="接收人员">
                            <el-input v-model="form.receiving" autocomplete="off"></el-input>
                        </el-form-item>
                    </el-form>
                    <div slot="footer" class="dialog-footer">
                        <el-button @click="dialogFormVisible = false">取 消</el-button>
                        <el-button type="primary" @click="save">确 定</el-button>
                    </div>
                    </el-dialog>
                </div>
            </div>
        </el-card>
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
        //     tableData: [{
        //     date: '2016-05-02',
        //     name: '王小虎',
        //     address: '上海市普陀区金沙江路 1518 弄'
        //   }, {
        //     date: '2016-05-04',
        //     name: '王小虎',
        //     address: '上海市普陀区金沙江路 1517 弄'
        //   }, {
        //     date: '2016-05-01',
        //     name: '王小虎',
        //     address: '上海市普陀区金沙江路 1519 弄'
        //   }, {
        //     date: '2016-05-03',
        //     name: '王小虎',
        //     address: '上海市普陀区金沙江路 1516 弄'
        //   }]
        }
    },
    created() {
        this.load()
    },
    methods: {
        load() {
            this.request.get("http://localhost:9090/announcement/page",{
                params: {
                    pageNum: this.pageNum,
                    pageSize: this.pageSize,
                    name: this.name
                }
                }).then(res => {
                console.log(res)

                this.tableData = res.data
                this.total = res.total
            })
        },
        save() {
            this.request.post("/announcement",this.form).then(res => {
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
        handleDelete(department) {
            this.request.delete("/announcement/" + department).then(res => {
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
        },
        clickMenu1() {
                this.$router.push("/enterprise"); 
        },
        handleAdd() {
            this.dialogFormVisible = true
            this.form = {}
        },
        clickMenu2() {
                this.$router.push("/organization"); 
        },
        clickMenu3() {
                this.$router.push("/permissions"); 
        },
        clickMenu4() {
                this.$router.push("/employee"); 
        },
        clickMenu5() {
                this.$router.push("/module"); 
        },
        clickMenu6() {
                this.$router.push("/product"); 
        },
        clickMenu7() {
                this.$router.push("/business"); 
        },
        clickMenu8() {
                this.$router.push("/field"); 
        },
        clickMenu9() {
                this.$router.push("/dictionary"); 
        },
        clickMenu10() {
                this.$router.push("/log"); 
        }
    }
}
</script>

<style>
.box {
    height: 1000px;
}
.d2 {
    width: 80px;
    height: 80px;
        border-radius: 50%;
        border:1px solid #9e9b9b;
        margin-left: 40px;
        margin-top: 40px;
        vertical-align: middle;
        }
.d3 {
        margin-left: 70px;
        position: relative;
        top: 5px;
        color: #757171;
}
.d4 {
    color: #757171;
    position: relative;
    top: -45px;
    left: 150px;
}
.d5 {
    color: #757171;
    position: relative;
    top: -90px;
    left: 400px;
}
.d6 {
    color: #757171;
    position: relative;
    top: -90px;
    left: 500px;
}
.d7 {
    color: #757171;
    position: relative;
    top: -90px;
    left: 600px;
}
.d8 {
    color: #757171;
    position: relative;
    top: -52px;
    left: 210px;
    font-size: 30px;
}
.d9 {
    color: #757171;
    position: relative;
    top: -52px;
    left: 320px;
    font-size: 30px;
}
.d10 {
    color: #757171;
    position: relative;
    top: -52px;
    left: 430px;
    font-size: 30px;
}

.i1 {
    margin-top: -10px;
    text-align: center;
    font-size: 40px;
}
.p1 {
    text-align: center;
    font-size: 20px;
}
</style>