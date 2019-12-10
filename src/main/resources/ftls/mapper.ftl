<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${BasePackageName}${DaoPackageName}${ClassName}Dao">

    <select id="get" resultType="${ClassName}">
        SELECT *
        FROM ${TableName}
        <where>
            ${TableName}.${PrimaryKey} = ${id}
        </where>
    </select>

    <select id="findList" resultType="${ClassName}">
        SELECT *
        FROM ${TableName}
    </select>

    <insert id="insert">
        INSERT INTO ${TableName}(
        ${InsertProperties}
        )
        VALUES (
        ${InsertValues}
        )
    </insert>

    <update id="update">
        UPDATE ${TableName} SET
        ${UpdateProperties}
        WHERE ${PrimaryKey} = ${id}
    </update>

    <update id="delete">
        DELETE FROM ${TableName}
        WHERE ${PrimaryKey} = ${id}
    </update>

</mapper>