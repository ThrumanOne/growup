package test;

import com.thruman.Api;
import com.thruman.dao.cluster.CAddressMapper;
import com.thruman.pojo.ProductEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 类说明
 * <p>
 *
 * @author niexiang
 * @version 1.0.0
 * @date 2018/12/10
 */
@SpringBootTest(classes = Api.class)
@RunWith(SpringRunner.class)
public class SpringTest {

    @Resource
    CAddressMapper cAddressMapper;

    @Test
    public void test(){
        ProductEntity select = cAddressMapper.select();
        System.out.print(select);


    }

}
