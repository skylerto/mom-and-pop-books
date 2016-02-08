package beans;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAddressBean.class, TestBookBean.class, TestPOBean.class, TestPOItemBean.class })
public class BeanTests {

}
