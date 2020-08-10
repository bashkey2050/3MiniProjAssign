package com.nit.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SsnGenerator implements IdentifierGenerator {

@Override
public Serializable generate(SharedSessionContractImplementor session, Object object)
        throws HibernateException {

    
    String prefix = "785";
 
    
    

    try {
    	Connection connection = session.connection();
        Statement statement=connection.createStatement();

        ResultSet rs=statement.executeQuery("select ssn_seq.nextVal from dual");

        if(rs.next())
        {
        	 int id=rs.getInt(1)+100001;
             String generatedId = prefix + new Integer(id).toString();
             Long ssn= Long.parseLong(generatedId);
             return ssn;
        	
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return null;
}
}
