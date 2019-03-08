package com.jk.jtms.dao;

import com.jk.jtms.entity.Wzss;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LITAO
 * @version V1.0
 * @Package com.jk.jtms.dao
 * @Title:
 * @Description:
 * @date 2019/1/7 16:34
 */
public interface UserRecordDao {
    List<Map<String,Object>> getUserJL(Map map);

    List<Map<String,Object>> getUserJLDetail(Map map);

    int getCount(@Param("carCode")String carCode);

    List<String> getCarCode(String userid);

    Integer getScore(Map map);

    Map<String,Object> getUserCredit(Map map);

    Map<String,Object> getCarDetails(String id);

    Integer sendSuSong(Wzss wzss);

    List<Wzss> queyrShenSu(String sfcode);

    List<Map<String,Object>> getWZDetails(Map map);

    Integer updateStatus(@Param("carcode") String carcode,@Param("time") String time);
}
