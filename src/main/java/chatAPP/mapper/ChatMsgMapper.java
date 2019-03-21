package chatAPP.mapper;

import chatAPP.model.ChatMsg;
import chatAPP.model.ChatMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatMsgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    long countByExample(ChatMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int deleteByExample(ChatMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int insert(ChatMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int insertSelective(ChatMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    List<ChatMsg> selectByExample(ChatMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    ChatMsg selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByExampleSelective(@Param("record") ChatMsg record, @Param("example") ChatMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByExample(@Param("record") ChatMsg record, @Param("example") ChatMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByPrimaryKeySelective(ChatMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated Thu Mar 21 15:51:23 AEDT 2019
     */
    int updateByPrimaryKey(ChatMsg record);
}