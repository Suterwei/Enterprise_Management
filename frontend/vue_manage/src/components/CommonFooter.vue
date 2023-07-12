<template>
    <div class="header-container">
        <div class="l-content">
            <span class="text">Copyright © www.meession.com, All Rights Reserved.</span>
        </div>
        <div class="r-content">
            <i class="el-icon-user"></i>
            <span class="text">微信公众号</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <i class="el-icon-user"></i>
            <span class="text">QQ交流</span>
            <i class="el-icon-user"></i>
            <span class="text">联系邮箱</span><br>
            <span class="text">搜索关注：meession_cn</span>&nbsp;&nbsp;                      
            <span class="text">4194534</span>&nbsp;
            <span class="text">ranbow.wong@meession.com</span>
        </div>
    </div>
</template>
<script>

export default {
    data() {
        return {}
    },
    methods: {
        handleMenu() {
            this.$store.commit('collapseMenu')
        }
    }
}
</script>
<style lang="less" scoped>
.header-container {
    padding: 0 20px;
    background-color: #858282;
    height: 60px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    .text {
        color: #cecbcb;
        font-size: 14px;
        margin-left: 10px;
        margin-right: 40px;
    }
    .r-content {
        .user {
            width: 40px;
            height: 40px;
            border-radius: 50%;
        }
    }
}
</style>