<template>
    <el-card>
        <div class="box">
            <div style="width: 600px; position: absolute; left: 30%;">
                <h3>基本信息</h3>
                <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="企业名称" prop="name">
                    <el-input v-model="ruleForm.name1"></el-input>
                </el-form-item>
                <el-form-item label="企业简称" prop="name">
                    <el-input v-model="ruleForm.name2"></el-input>
                </el-form-item>
                <el-form-item label="企业电话" prop="name">
                    <el-input v-model="ruleForm.name3"></el-input>
                </el-form-item>
                <el-form-item label="企业类型" prop="region">
                    <el-select v-model="ruleForm.regio1" placeholder="请选择活动区域">
                    <el-option label="国有企业" value="shanghai"></el-option>
                    <el-option label="集体企业" value="beijing"></el-option>
                    <el-option label="联营企业" value="beijing"></el-option>
                    <el-option label="股份合作制企业" value="beijing"></el-option>
                    <el-option label="私营企业" value="beijing"></el-option>
                    <el-option label="个体户" value="beijing"></el-option>
                    <el-option label="合伙企业" value="beijing"></el-option>
                    <el-option label="有限责任公司" value="beijing"></el-option>
                    <el-option label="股份有限公司" value="beijing"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="所属行业" prop="region">
                    <el-select v-model="ruleForm.region2" placeholder="请选择活动区域">
                    <el-option label="计算机行业" value="shanghai"></el-option>
                    <el-option label="金融行业" value="beijing"></el-option>
                    <el-option label="其他" value="beijing"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="所在地区" prop="region">
                    <el-select v-model="ruleForm.region1" placeholder="请选择活动区域">
                    <el-option label="湖南" value="shanghai"></el-option>
                    <el-option label="其他" value="beijing"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="详细地址" prop="name">
                    <el-input v-model="ruleForm.name4"></el-input>
                </el-form-item>
                <el-form-item label="邮政编码" prop="name">
                    <el-input v-model="ruleForm.name5"></el-input>
                </el-form-item>
                <el-form-item label="企业传真" prop="name">
                    <el-input v-model="ruleForm.name6"></el-input>
                </el-form-item>
                <el-form-item label="企业网址" prop="name">
                    <el-input v-model="ruleForm.name7"></el-input>
                </el-form-item>
                <el-form-item label="成立时间" prop="name">
                    <el-input v-model="ruleForm.name8"></el-input>
                </el-form-item>
                </el-form>
                <h3>公司Logo</h3>
                <el-upload
                    class="upload-demo"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :on-preview="handlePreview"
                    :on-remove="handleRemove"
                    :before-remove="beforeRemove"
                    multiple
                    :limit="3"
                    :on-exceed="handleExceed"
                    :file-list="fileList">
                    <el-button size="small" type="primary">点击上传</el-button>
                    <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                </el-upload>
                <el-upload
                    class="upload-demo"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :on-preview="handlePreview"
                    :on-remove="handleRemove"
                    :file-list="fileList"
                    list-type="picture">
                    <el-button size="small" type="primary">点击上传</el-button>
                    <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                    </el-upload><br>
                <h3>企业联系人</h3>
                <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="联系人姓名" prop="name">
                        <el-input v-model="ruleForm.name9"></el-input>
                    </el-form-item>
                    <el-form-item label="尊称" prop="resource">
                        <el-radio-group v-model="ruleForm.resource">
                        <el-radio label="未知"></el-radio>
                        <el-radio label="先生"></el-radio>
                        <el-radio label="女士"></el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="部门职务" prop="name">
                        <el-input v-model="ruleForm.name10"></el-input>
                    </el-form-item>
                    <el-form-item label="手机号码" prop="name">
                        <el-input v-model="ruleForm.name11"></el-input>
                    </el-form-item>
                    <el-form-item label="电子邮箱" prop="name">
                        <el-input v-model="ruleForm.name12"></el-input>
                    </el-form-item>
                </el-form>
                <div>
                    <el-button type="primary" style="position: relative;left: 300px;" @click="handleno">保存</el-button>
                </div>
            </div>
        </div>
    </el-card>

</template>
<script>
  export default {
    data() {
      return {
        ruleForm: {
          name1: '',
          name2: '',
          name3: '',
          name4: '',
          name5: '',
          name6: '',
          name7: '',
          name8: '',
          name9: '',
          name10: '',
          name11: '',
          name12: '',
          region1: '',
          region2: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        fileList: [{name: 'tiger.pbg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}],
        fileList: [{name: 'tiger.jpeg', url: 'https://s1.ax1x.com/2023/07/10/pCRrBGT.png'}, {name: 'food.png', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}],  
        // rules: {
        //   name: [
        //     { required: true, trigger: 'blur' },
        //     { min: 3, max: 5, trigger: 'blur' }
        //   ],
        //   region: [
        //     { required: true, trigger: 'change' }
        //   ],
        //   date1: [
        //     { type: 'date', trigger: 'change' }
        //   ],
        //   date2: [
        //     { type: 'date', required: true, trigger: 'change' }
        //   ],
        //   type: [
        //     { type: 'array', required: true, trigger: 'change' }
        //   ],
        //   resource: [
        //     { required: true, trigger: 'change' }
        //   ],
        //   desc: [
        //     { required: true, trigger: 'blur' }
        //   ]
        // }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      },
      handleno() {
        alert("保存成功！");
      }
    }
  }
</script>

<style>
.box {
    height: 1500px;
}
</style>