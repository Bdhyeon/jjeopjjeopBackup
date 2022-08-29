package com.jjeopjjeop.recipe.dao;

import com.jjeopjjeop.recipe.dto.CommunityDTO;
import com.jjeopjjeop.recipe.dto.RecipeDTO;
import com.jjeopjjeop.recipe.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDAO {
   public List<UserDTO> selectAllUserList() throws DataAccessException;
   public int insertUser(UserDTO userDTO) throws DataAccessException;
   public int deleteUser(String user_id, String password) throws DataAccessException;
   public int checkId(String user_id) throws DataAccessException;
   public UserDTO loginById(UserDTO userDTO) throws DataAccessException;
   public UserDTO findId(UserDTO userDTO) throws DataAccessException;
   public UserDTO findPassword(UserDTO userDTO) throws DataAccessException;
   public int updatePassword(UserDTO userDTO) throws DataAccessException;
   public UserDTO readMypage(String user_id) throws DataAccessException;
   public int updateMypage(UserDTO userDTO) throws DataAccessException;
   public List<UserDTO> showMyCommunity(String user_id) throws DataAccessException;
   public List<CommunityDTO> viewMyCommunity(Map<String, Object> map) throws DataAccessException;
   public List<RecipeDTO> viewMyRecipe(Map<String, Object> map) throws DataAccessException;
   public List<CommunityDTO> viewMyReview(Map<String, Object> map) throws DataAccessException;
   public int countMyCommunity(String user_id) throws DataAccessException;
   public int countMyRecipe(String user_id) throws DataAccessException;
   public int countMyReview(String user_id) throws DataAccessException;

    UserDTO findUserById(String user_id);
}
