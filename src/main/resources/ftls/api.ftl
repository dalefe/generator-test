import request from '@//utils/request'

// 获取全部数据
export function findList${ClassName}() {
    return request({
        url: '/findList${ClassName}',
        method: 'get',
    })
}

// 插入数据
export function insert${ClassName}(${EntityName}) {
    return request({
        url: '/insert${ClassName}',
        method: 'post',
        data: ${EntityName}
    })
}

// 修改数据
export function update${ClassName}(${EntityName}) {
    return request({
        url: '/update${ClassName}',
        method: 'post',
        data: ${EntityName}
    })
}

// 删除数据
export function delete${ClassName}(${EntityName}) {
    return request({
        url: '/delete${ClassName}',
        method: 'post',
        data: ${EntityName}
    })
}