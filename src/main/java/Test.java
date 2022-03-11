import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.Date;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2022/1/25 14:28
 * @Created by hyy
 */
public class Test {
    public static void main(String[] args) {
        String fortamt = DateUtil.format(new Date(), "yyyyMMdd") + RandomUtil.randomNumbers(4);
        System.out.println(fortamt);
        fortamt = String.valueOf(Long.parseLong(fortamt) << 1);
        System.out.println(fortamt);
    }
}
