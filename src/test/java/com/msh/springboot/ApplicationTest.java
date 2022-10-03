package com.msh.springboot;

import com.msh.springboot.bean.Furn;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ApplicationTest {

    @Resource
    private JdbcTemplate jdbcTemplate;
    @Test
    public void contextLoads(){
        BeanPropertyRowMapper<Furn> rowMapper = new BeanPropertyRowMapper<>(Furn.class);
        List<Furn> furns = jdbcTemplate.query("select * from `furn`", rowMapper);
        for (Furn furn : furns) {
            System.out.println(furn);
        }

    }

    @Test
    public void t1(){
        System.out.println(jdbcTemplate.getDataSource().getClass());
    }
}
