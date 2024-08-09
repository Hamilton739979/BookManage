package book.manager.mapper;

import book.manager.entity.authUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from users where name = #{username}")
    authUser getPasswordByUsername(String username);

    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("insert into users(name,role,password) values(#{name},#{role},#{password})")
    int registerUser(authUser user);

    @Insert("insert into student(uid,name,sex,grade) values(#{uid},#{name},#{sex},#{grade})")
    int addStudentInfo(@Param("uid") int uid,@Param("name") String name,@Param("sex") String sex,@Param("grade") String grade);

    @Select("select sid from student where uid = #{uid}")
    Integer getSidByUserId(int uid);

    @Select("select count(*) from student")
    int getStudentCount();
}
