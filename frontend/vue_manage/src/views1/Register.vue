<template>
    <div class="login">
      <div class="mylogin" align="center">
        <h4>注册</h4>
        <el-form
          :model="form"
          ref="form"
          label-width="0px"
        >
          <el-form-item label="" prop="name" style="margin-top: 10px">
            <el-row>
              <el-col :span="2">
                <span class="el-icon-s-custom"></span>
              </el-col>
              <el-col :span="22">
                <el-input
                  class="inps"
                  placeholder="账号"
                  v-model="form.name"
                >
                </el-input>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item label="" prop="password">
            <el-row>
              <el-col :span="2">
                <span class="el-icon-lock"></span>
              </el-col>
              <el-col :span="22">
                <el-input
                  class="inps"
                  type="password"
                  placeholder="密码"
                  v-model="form.password"
                ></el-input>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item style="margin-top: 55px">
            <el-button type="primary" round class="handleClick" @click="handleClick"
              >注册
            </el-button>
          </el-form-item>
          <!-- <div class="unlogin">
            <router-link :to="{ path: '/forget' }"> 忘记密码? </router-link>
            |
            <router-link :to="{ path: '/register' }">
              <a href="register.vue" target="_blank" align="right">注册新账号</a>
            </router-link>
          </div> -->
        </el-form>
      </div>
    </div>
  </template>

<script>
import { mapMutations } from "vuex";
import { Message } from "element-ui";
 
export default {
  name: "Login",
  data: function () {
    return {
        form: {
        name: "",
        password: "",
      },
    };
  },
 
  methods: {
    handleClick() {
        this.request.get("http://localhost:9090/login/page?name=123&password=123",{
                params: {
                    name: this.name,
                    password:this.password
                }
                }).then(res => {
                console.log(res)
                console.log(name)

                    Message({
                    message: "注册成功！！！",
                    type: "success",
                });
                    this.$router.push("/");
                this.tableData = res.data
                this.total = res.total
            })
    }
  },
};
</script>

<style>
  .login {
    width: 100vw;
    padding: 0;
    margin: 0;
    height: 100vh;
    font-size: 16px;
    background-position: left top;
    background-color: #7f8482;
    color: #fff;
    font-family: "Source Sans Pro";
    position: relative;
  }
 
  .mylogin {
    width: 240px;
    height: 280px;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    margin: auto;
    padding: 50px 40px 40px 40px;
    box-shadow: -15px 15px 15px rgba(6, 17, 47, 0.7);
    opacity: 1;
    background: linear-gradient(
      230deg,
      rgba(53, 57, 74, 0) 0%,
      rgb(0, 0, 0) 100%
    );
  }
 
  .inps input {
    border: none;
    color: #fff;
    background-color: transparent;
    font-size: 12px;
  }
 
  .submitBtn {
    background-color: transparent;
    color: #39f;
    width: 200px;
  }

  .router-link-active {
    text-decoration: none;
    color: #b9b1b1;
    }
    a {
        text-decoration: none;
        color: #c0a8a8;
    }
</style>