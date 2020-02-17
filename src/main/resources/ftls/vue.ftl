<template>
    <div>
        <div class="band_top" style="background: #191970">
            <sticky :z-index="10" class-name="sub-navbar">
                <div class="select-course">
                    <div style="float:left">
                        <el-input
                                placeholder="请输入字段ID"
                                v-model="selectById"
                                class="input-with-select"
                                style="width: 400px; padding-left: 10px; padding-top: 3px;"
                        >
                            <el-button slot="append" @click="selectByIdClick" icon="el-icon-search"></el-button>
                        </el-input>
                    </div>
                    <div style="float:right; padding-right: 10px; padding-top: 3px;">
                        <el-button type="success" @click="insterOnce" icon="el-icon-edit">添加</el-button>
                    </div>
                </div>
            </sticky>
        </div>
        <div class="table_box">
            <el-table
                    empty-text="表中暂无数据"
                    element-loading-text="正在加载数据"
                    size="small"
                    border
                    fit
                    highlight-current-row
                    v-loading="listLoading"
                    :data="tableInnerInfo"
                    @selection-change="handleSelectionChange"
            >
                <el-table-column
                        v-for="iHead in tableHeadInfo"
                        :key="iHead.key"
                        :label="iHead.label"
                        :property="iHead.key"
                        align="center"
                >
                    <template slot-scope="scope">{{ scope.row[scope.column.property]}}</template>
                </el-table-column>
                <el-table-column align="center" label="操作" max-width="50px;">
                    <template slot-scope="scope">
                        <el-row>
                            <el-col :span="12">
                                <el-button
                                        type="primary"
                                        @click="updateOnce(scope.$index,tableInnerInfo)"
                                        size="small"
                                >修改</el-button>
                            </el-col>
                            <el-col :span="12">
                                <el-button
                                        type="danger"
                                        @click="deleteOnce(scope.$index,tableInnerInfo)"
                                        size="small"
                                >删除</el-button>
                            </el-col>
                        </el-row>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <!-- 更新 -->
        <el-dialog
                title="更新详情"
                :visible.sync="udialogVisible"
                width="90%"
                center
                :show-close="false"
                :close-on-press-escape="false"
                :before-close="handleClose"
        >
            <el-table :data="updatedClass" border>
                <el-table-column
                        v-for="iHead in tableHeadInfo"
                        :key="iHead.key"
                        :label="iHead.label"
                        :property="iHead.key"
                        align="center"
                >
                    <template slot-scope="scope">
                        <el-form ref="updateFrom" :model="updateFrom">
                            <el-form-item>
                                <el-input
                                        :placeholder="updateFrom[scope.column.property]"
                                        v-model="updateFrom[scope.column.property]"
                                />
                            </el-form-item>
                        </el-form>
                        <!--:placeholder="scope.row[scope.column.property]" -->
                    </template>
                </el-table-column>
            </el-table>
            <span slot="footer" class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="updateConfirm">确 定</el-button>
      </span>
        </el-dialog>
        <!-- 插入 -->
        <el-dialog
                title="按字段插入"
                :visible.sync="idialogVisible"
                width="90%"
                :show-close="false"
                :close-on-press-escape="false"
                center
                :before-close="handleClose"
        >
            <el-table :data="insertClass" border>
                <el-table-column
                        v-for="iHead in tableHeadInfo"
                        :key="iHead.key"
                        :label="iHead.label"
                        :property="iHead.key"
                        align="center"
                >
                    <template slot-scope="scope">
                        <el-form :model="insertOnceFrom">
                            <el-form-item>
                                <el-input v-model="insertOnceFrom[scope.column.property]" />
                            </el-form-item>
                        </el-form>
                    </template>
                </el-table-column>
            </el-table>
            <span slot="footer" class="dialog-footer">
        <el-button @click="insertcancel">取 消</el-button>
        <el-button type="primary" @click="insertConfirm">确 定</el-button>
      </span>
        </el-dialog>
        <!-- 按ID查找 -->
        <el-dialog
                title="查找详情"
                :visible.sync="sdialogVisible"
                width="90%"
                :show-close="false"
                :close-on-press-escape="false"
                center
        >
            <el-table :data="selectedDate" border empty-text="暂无数据">
                <el-table-column
                        v-for="iHead in tableHeadInfo"
                        :key="iHead.key"
                        :label="iHead.label"
                        :property="iHead.key"
                        align="center"
                >
                    <template slot-scope="scope">{{ scope.row[scope.column.property]}}</template>
                </el-table-column>
            </el-table>
            <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="selectConfirm">知道了</el-button>
      </span>
        </el-dialog>
    </div>
</template>

<script>
    import NProgress from "nprogress"; // progress bar
    import "nprogress/nprogress.css"; // progress bar style
    NProgress.configure({ showSpinner: false }); // NProgress configuration
    import Sticky from "@/components/Sticky";
    import BackToTop from "@/components/BackToTop";

    import {
        findList${ClassName},
        update${ClassName},
        delete${ClassName},
        insert${ClassName}
    } from "@/api/${ClassName}";
    import { Message, MessageBox } from "element-ui";

    export default {
        components: { Sticky, BackToTop },
        data() {
            return {
                // 按ID查找
                selectById: null,
                selectedDate: [],
                // 针对elementUI Dialog的bug维护一个标记
                isDialogClick: true,
                // 新增一条
                insertOnceFrom: {},
                insertClass: [],
                // 维护一个更新对象
                updateFrom: {},
                updatedClass: [],
                sdialogVisible: false,
                udialogVisible: false,
                idialogVisible: false,
                // 数据库表头部信息
                tableHeadInfo: [],
                tableInnerInfo: [],
                listLoading: false
            };
        },
        mounted() {
            NProgress.start();
            findList${ClassName}()
                .then(response => {
                if (response.code == 200) {
                this.tableHeadInfo = response.extend.data.tableHeadInfo;
                this.tableInnerInfo = response.extend.data.tableInnerInfo;
            } else if (response.code == 405) {
                Message({
                    message: "数据库操作异常",
                    type: "error",
                    duration: 5 * 1000
                });
            }
        })
        .catch(response => {
                Message({
                            message: "查询失败",
                            type: "error",
                            duration: 5 * 1000
        });
        });
            NProgress.done();
        },
        methods: {
            selectByIdClick() {
                if (this.isDialogClick) {
                    this.isDialogClick = false;
                    // 前端做一下缓存
                    for (let val of this.tableInnerInfo) {
                        console.log(val.id);
                        console.log(this.selectById);
                        debugger;
                        if (val.id == this.selectById) {
                            this.selectedDate.push(val);
                        }
                    }
                    // 若缓存无，则向后端传递ID
                    // this.selectById
                    // this.selectedDate.push
                    // 这里暂时没有向后端查询，只要保持回调一致即可
                    this.sdialogVisible = true;
                }
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            updateOnce(index, rows) {
                console.log("当前更新行：", rows[index]);
                this.udialogVisible = true;
                if (this.isDialogClick) {
                    this.updateFrom = rows[index];
                    this.updatedClass.push(rows[index]);
                    console.log("点击修改按钮：", this.updatedClass);
                    console.log("点击修改按钮from：", this.updateFrom);
                    this.isDialogClick = false;
                }
            },
            deleteOnce(index, rows) {
                let deleteFlag = false;
                // 调用后端删除，返回确定删除后
                this.$confirm("是否确定删除？", "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                })
                    .then(() => {
                    deleteFlag = true;
                console.log(deleteFlag);
                // 根据ID删除
                delete${ClassName}(rows[index]).then(response => {
                    console.log(rows[index].uuid);
                if (deleteFlag) {
                    rows.splice(index, 1);
                }
                this.$message({
                    type: "success",
                    message: "删除成功!"
                });
            });
            })
            .catch(() => {
                    deleteFlag = false;
                this.$message({
                    type: "warning",
                    message: "已取消删除"
                });
            });
            },
            handleClose(done, updateList) {
                this.$confirm("确认关闭？")
                    .then(_ => {
                    done();
            })
            .catch(_ => {});
            },
            cancel() {
                (this.udialogVisible = false), (this.updatedClass.length = 0);
                console.log(this.updatedClass);
                this.$message({
                    type: "warning",
                    message: "已取消修改！"
                });
                this.isDialogClick = true;
            },
            updateConfirm() {
                this.udialogVisible = false;
                this.updatedClass.length = 0;
                console.log("from:", this.updateFrom);
                // 对后端提供this.updateFrom.uuid
                // 访问后端
                update${ClassName}(this.updateFrom).then(response => {});
                this.$message({
                    type: "success",
                    message: "修改成功!(id不可修改)"
                });
                this.isDialogClick = true;
            },
            insterOnce(index, rows) {
                this.idialogVisible = true;
                var obj = new Object();
                for (let val of this.tableHeadInfo) {
                    obj[val.key] = "";
                }
                if (this.isDialogClick) {
                    console.log(obj);
                    this.insertOnceFrom = obj;
                    this.insertClass.push(obj);
                    console.log("一次调用！！！");
                    this.isDialogClick = false;
                }
            },
            insertConfirm() {
                insert${ClassName}(this.insertOnceFrom).then(response => {
                    console.log(response);
                if (response.code == 200) {
                    this.idialogVisible = false;
                    this.insertClass.length = 0;
                    console.log("插入：", this.insertOnceFrom);
                    this.tableInnerInfo.push(this.insertOnceFrom);
                    this.$message({
                        type: "success",
                        message: "添加成功!"
                    });
                    // 在明确回调之后清除isDialogClick
                    this.isDialogClick = true;
                }
            });
            },
            insertcancel() {
                this.idialogVisible = false;
                this.insertClass.length = 0;
                this.$message({
                    type: "warning",
                    message: "已取消添加！"
                });
                this.isDialogClick = true;
            },
            selectConfirm() {
                this.isDialogClick = true;
                this.sdialogVisible = false;
                this.selectedDate.length = 0;
            }
        }
    };
</script>

<style>
    .band_top {
        margin-top: 10px;
    }
    .table_box {
        margin-right: 5px;
        margin-left: 5px;
        padding-top: 50px;
        max-width: 1500px;
        box-shadow: 0px 0px 10px 0px rgba(182, 182, 182, 0.5),
        0px 0px 1px 0px rgba(255, 255, 255, 0.5);
    }
</style>