package com.loosu.downloaddemo.domain;

import android.support.annotation.Nullable;

import com.alibaba.fastjson.annotation.JSONField;

public class MovieBean {
    /**
     * id : 36
     * title : 倒贴钱
     * media : http://ivystorage.oss-cn-shenzhen.aliyuncs.com/videos/2018-07-31/20180731o5sv2qj4jnaxqo7qute.mp4?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=ZUCSUP5CsUXDlRXWNtyau7vv%2Flw%3D
     * comments : 63
     * star : 7
     * like : 4
     * is_like : 0
     * uid : 8272552
     * created_at : 2018-07-31 13:32:56
     * address :
     * cover : http://ivystorage.oss-cn-shenzhen.aliyuncs.com/images/2018-07-31/20180731o5sv2qj4jnaxqo7qute.png?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=N7gvyPLtL9UMFA0ziQb1cVXoRIY%3D
     * video_length : 00:59
     * share : 0
     * username : cloud
     * avatar : http://thirdwx.qlogo.cn/mmopen/7Ah0ckg8qvEia2T0iamIfhCGQcgISxg0iaKOkuWbxkhGPYjoce5gmkySINKILiaRyMP2wdyd2wdyjFOFDAgqFJOnXFEL49ic53KUX/132
     * is_star : 0
     */

    @JSONField(name = "id")
    private int mId;
    @JSONField(name = "title")
    private String mTitle;
    @JSONField(name = "media")
    private String mMedia;
    @JSONField(name = "comments")
    private String mComments;
    @JSONField(name = "star")
    private String mStar;
    @JSONField(name = "like")
    private String mLike;
    @JSONField(name = "is_like")
    private int mIsLike;
    @JSONField(name = "uid")
    private String mUid;
    @JSONField(name = "created_at")
    private String mCreatedAt;
    @JSONField(name = "address")
    private String mAddress;
    @JSONField(name = "cover")
    private String mCover;
    @JSONField(name = "video_length")
    private String mVideoLength;
    @JSONField(name = "share")
    private String mShare;
    @JSONField(name = "username")
    private String mUsername;
    @JSONField(name = "avatar")
    private String mAvatar;
    @JSONField(name = "is_star")
    private int mIsStar;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getMedia() {
        return mMedia;
    }

    public void setMedia(String media) {
        mMedia = media;
    }

    public String getComments() {
        return mComments;
    }

    public void setComments(String comments) {
        mComments = comments;
    }

    public String getStar() {
        return mStar;
    }

    public void setStar(String star) {
        mStar = star;
    }

    public String getLike() {
        return mLike;
    }

    public void setLike(String like) {
        mLike = like;
    }

    public int getIsLike() {
        return mIsLike;
    }

    public void setIsLike(int isLike) {
        mIsLike = isLike;
    }

    public String getUid() {
        return mUid;
    }

    public void setUid(String uid) {
        mUid = uid;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getCover() {
        return mCover;
    }

    public void setCover(String cover) {
        mCover = cover;
    }

    public String getVideoLength() {
        return mVideoLength;
    }

    public void setVideoLength(String videoLength) {
        mVideoLength = videoLength;
    }

    public String getShare() {
        return mShare;
    }

    public void setShare(String share) {
        mShare = share;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

    public int getIsStar() {
        return mIsStar;
    }

    public void setIsStar(int isStar) {
        mIsStar = isStar;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof MovieBean)) {
            return false;
        }
        return ((MovieBean) obj).getId() == this.getId();
    }
}