package com.mvcapp1.daopackage;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.mvcapp1.controllerpackage.UserData;

public class UserMapper implements RowMapper<UserData> {
   public UserData mapRow(ResultSet rs, int rowNum) throws SQLException {
      UserData User = new UserData();
      User.setId(rs.getInt("id"));
      User.setFirstName(rs.getString("firstname"));
      User.setLastName(rs.getString("lastname"));
      
      return User;
   }
}
