package net.wanho.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Jerk on 2019/5/29.
 */
@Data

public class Student {

    private Integer id;
    private String sname;
    private Integer age;
    private String gender;
    private String address;

}
