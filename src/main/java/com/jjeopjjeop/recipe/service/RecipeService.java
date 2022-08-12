package com.jjeopjjeop.recipe.service;

import com.jjeopjjeop.recipe.dto.*;

import java.util.List;

public interface RecipeService {
    public int countProcess(int cate_seq);
    public List<RecipeDTO> listProcess(RecipePageDTO recipePageDTO);
    public int searchCountProcess(RecipePageDTO recipePageDTO);
    public List<RecipeDTO> searchListProcess(RecipePageDTO recipePageDTO);
    public List<RecipeDTO> favoriteListProcess();
    public List<CategoryDTO> cateListProcess();
    public RecipeDTO contentProcess(int rcp_seq);
    public List<ManualDTO> contentMnlProcess(int rcp_seq);
    public int chkScrapProcess(UserScrapDTO userScrapDTO);
    public void scrapProcess(UserScrapDTO userScrapDTO);
    public void reportProcess(ReportRecipeDTO reportRecipeDTO);
    public void writeProcess(RecipeDTO recipeDTO);
    public void writeMProcess(ManualDTO manualDTO);
    public void writeCProcess(int cate_seq);
    public void deleteProcess(int rcp_seq);

    //hayeong
    List<RecipeDTO> searchListByKeyword(String searchKey);
}
