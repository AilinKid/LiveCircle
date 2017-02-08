/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.lvr.livecircle.news.db;


import com.lvr.livecircle.R;
import com.lvr.livecircle.api.ApiConstants;
import com.lvr.livecircle.app.AppApplication;
import com.lvr.livecircle.news.model.bean.NewsChannelTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsChannelTableManager {

    /**
     * 加载新闻类型
     *
     * @return
     */


    public static List<NewsChannelTable> loadNewsChannelsMine() {
        List<String> channelName = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.news_channel_name));
        List<String> channelId = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.news_channel_id));
        List<Integer> channelImgRes = Arrays.asList(R.drawable.news_house,R.drawable.news_play,
                R.drawable.news_movie,R.drawable.news_car,R.drawable.news_game,
                R.drawable.news_education,R.drawable.news_travel,R.drawable.news_mobile,R.drawable.news_social);
        ArrayList<NewsChannelTable> newsChannelTables = new ArrayList<>();
        for (int i = 0; i < channelName.size(); i++) {
            NewsChannelTable entity = new NewsChannelTable(channelName.get(i), channelId.get(i)
                    , ApiConstants.getType(channelId.get(i)), i <= 5, i, false, channelImgRes.get(i));
            newsChannelTables.add(entity);
        }
        return newsChannelTables;
    }

    /**
     * 加载固定新闻类型
     *
     * @return
     */

    public static List<NewsChannelTable> loadNewsChannelsStatic() {
        List<String> channelName = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.news_channel_name_static));
        System.out.println(channelName);
        List<String> channelId = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.news_channel_id_static));
        List<Integer> channelImgRes = Arrays.asList(R.drawable.news_header,R.drawable.news_tech,
                R.drawable.news_fincial,R.drawable.news_military,R.drawable.news_sports);
        ArrayList<NewsChannelTable> newsChannelTables = new ArrayList<>();
        for (int i = 0; i < channelName.size(); i++) {
            NewsChannelTable entity = new NewsChannelTable(channelName.get(i), channelId.get(i)
                    , ApiConstants.getType(channelId.get(i)), i <= 5, i, true, channelImgRes.get(i));
            newsChannelTables.add(entity);
        }
        return newsChannelTables;
    }
}
