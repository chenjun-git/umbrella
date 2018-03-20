package com.scc.umbrella.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chenjun on 18/3/12.
 */

public class News {
    public String media_name;
    @SerializedName("abstract")
    public String abstractX;
    public int impression_count;
    public String media_avatar_url;
    public int external_visit_count;
    public int article_type;
    public boolean more_mode;
    public String tag;
    public int is_favorite;
    public int has_m3u8_video;
    public String keywords;
    public String chinese_tag;
    public int has_mp4_video;
    public int favorite_count;
    public String display_url;
    public int article_sub_type;
    public String tag_url;
    public int bury_count;
    public String title;
    public String datetime;
    public boolean has_video;
    public String share_url;
    public long id;
    public String source;
    public int comment_count;
    public String article_url;
    public long create_time;
    public int recommend;
    public int tips;
    public int aggr_type;
    public String item_source_url;
    public String media_url;
    public long display_time;
    public int publish_time;
    public int go_detail_count;
    public int group_flags;
    public boolean middle_mode;
    public String display_title;
    public int gallary_image_count;
    public String item_seo_url;
    public long tag_id;
    public String source_url;
    public String article_genre;
    public boolean large_mode;
    public long item_id;
    public int natant_level;
    public int is_digg;
    public String seo_url;
    public int repin_count;
    public String url;
    public int level;
    public int digg_count;
    public long behot_time;
    public int hot;
    public int preload_web;
    public int comments_count;
    public boolean has_image;
    public int is_bury;
    public String group_id;
    public String video_duration_str;
    public String image_url;
    public String video_id;
    public List<ImageUrl> image_list;

    public Video video;
}
