<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="题目标题" prop="title">
      <el-input v-model="dataForm.title" placeholder="题目标题"></el-input>
    </el-form-item>
    <el-form-item label="题目解答" prop="answer">
      <el-input v-model="dataForm.answer" placeholder="题目解答"></el-input>
    </el-form-item>
    <el-form-item label="题目难度等级" prop="level">
      <el-input v-model="dataForm.level" placeholder="题目难度等级"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="displayOrder">
      <el-input v-model="dataForm.displayOrder" placeholder="排序"></el-input>
    </el-form-item>
    <el-form-item label="副标题" prop="subTitle">
      <el-input v-model="dataForm.subTitle" placeholder="副标题"></el-input>
    </el-form-item>
    <el-form-item label="题目类型" prop="type">
      <el-input v-model="dataForm.type" placeholder="题目类型"></el-input>
    </el-form-item>
    <el-form-item label="是否显示" prop="enable">
      <el-input v-model="dataForm.enable" placeholder="是否显示"></el-input>
    </el-form-item>
    <el-form-item label="删除标记（0-正常，1-删除）" prop="delFlag">
      <el-input v-model="dataForm.delFlag" placeholder="删除标记（0-正常，1-删除）"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          title: '',
          answer: '',
          level: '',
          displayOrder: '',
          subTitle: '',
          type: '',
          enable: '',
          delFlag: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          title: [
            { required: true, message: '题目标题不能为空', trigger: 'blur' }
          ],
          answer: [
            { required: true, message: '题目解答不能为空', trigger: 'blur' }
          ],
          level: [
            { required: true, message: '题目难度等级不能为空', trigger: 'blur' }
          ],
          displayOrder: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ],
          subTitle: [
            { required: true, message: '副标题不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '题目类型不能为空', trigger: 'blur' }
          ],
          enable: [
            { required: true, message: '是否显示不能为空', trigger: 'blur' }
          ],
          delFlag: [
            { required: true, message: '删除标记（0-正常，1-删除）不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/question/question/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.title = data.question.title
                this.dataForm.answer = data.question.answer
                this.dataForm.level = data.question.level
                this.dataForm.displayOrder = data.question.displayOrder
                this.dataForm.subTitle = data.question.subTitle
                this.dataForm.type = data.question.type
                this.dataForm.enable = data.question.enable
                this.dataForm.delFlag = data.question.delFlag
                this.dataForm.createTime = data.question.createTime
                this.dataForm.updateTime = data.question.updateTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/question/question/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'title': this.dataForm.title,
                'answer': this.dataForm.answer,
                'level': this.dataForm.level,
                'displayOrder': this.dataForm.displayOrder,
                'subTitle': this.dataForm.subTitle,
                'type': this.dataForm.type,
                'enable': this.dataForm.enable,
                'delFlag': this.dataForm.delFlag,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
