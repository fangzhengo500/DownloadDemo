package com.loosu.downloaddemo.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class IndexCategoryResponse {

    /**
     * status : 1
     * info : ok
     * data : [{"id":36,"title":"倒贴钱","media":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/videos/2018-07-31/20180731o5sv2qj4jnaxqo7qute.mp4?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=ZUCSUP5CsUXDlRXWNtyau7vv%2Flw%3D","comments":"63","star":"7","like":"4","is_like":0,"uid":"8272552","created_at":"2018-07-31 13:32:56","address":"","cover":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/images/2018-07-31/20180731o5sv2qj4jnaxqo7qute.png?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=N7gvyPLtL9UMFA0ziQb1cVXoRIY%3D","video_length":"00:59","share":"0","username":"cloud","avatar":"http://thirdwx.qlogo.cn/mmopen/7Ah0ckg8qvEia2T0iamIfhCGQcgISxg0iaKOkuWbxkhGPYjoce5gmkySINKILiaRyMP2wdyd2wdyjFOFDAgqFJOnXFEL49ic53KUX/132","is_star":0},{"id":33,"title":"驻港仪仗队相助礼兵求婚","media":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/videos/2018-07-31/20180731hz7sulp2cai3e5oyv12.mp4?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=VPeuIIovGwTpmwqGon1p3gpU55w%3D","comments":"1","star":"6","like":"4","is_like":0,"uid":"8272552","created_at":"2018-07-31 12:22:51","address":"","cover":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/images/2018-07-31/20180731hz7sulp2cai3e5oyv12.png?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=ib56RKDkunz6Gig7duvHLaqXp6o%3D","video_length":"00:38","share":"2","username":"cloud","avatar":"http://thirdwx.qlogo.cn/mmopen/7Ah0ckg8qvEia2T0iamIfhCGQcgISxg0iaKOkuWbxkhGPYjoce5gmkySINKILiaRyMP2wdyd2wdyjFOFDAgqFJOnXFEL49ic53KUX/132","is_star":0},{"id":274,"title":"美图手机拍摄","media":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/993c/201808/20180831b46674900887858234f8a9b59cee8240.mp4?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=F6HwI9nETuwuPo6UbpM1HL4o%2B3c%3D","comments":"9","star":"6","like":"2","is_like":0,"uid":"8272525","created_at":"2018-08-31 14:06:39","address":"","cover":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/993c/201808/20180831b46674900887858234f8a9b59cee8240.png?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=UHrfjiz%2BVSqUu6yeYdcXyJ0AHik%3D","video_length":"00:11","share":"0","username":"wengjf","avatar":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/993c/201808/201808268d48d1d96dff05c2dc5fa6e125a8415f.png","is_star":0},{"id":257,"title":"自己","media":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/993c/201808/20180823097cd290058f197f1ebbf5f7503eaaee.mp4?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=50BkidTlZT38MtPbUDWj4%2BjmO0U%3D","comments":"10","star":"5","like":"1","is_like":0,"uid":"8272525","created_at":"2018-08-23 15:39:39","address":"","cover":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/993c/201808/20180823097cd290058f197f1ebbf5f7503eaaee.png?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=%2FtoUg2ROZ9KbaGB16gw0b5lT1oQ%3D","video_length":"00:01","share":"0","username":"wengjf","avatar":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/993c/201808/201808268d48d1d96dff05c2dc5fa6e125a8415f.png","is_star":0},{"id":39,"title":"海鸥","media":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/videos/2018-07-31/201807311248455b443aad51b8d.mp4?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=Ydx%2FWZVkQQBtcXZxnZMjgXG75LE%3D","comments":"7","star":"3","like":"1","is_like":0,"uid":"8272549","created_at":"2018-07-31 16:21:10","address":"深圳南山区","cover":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/images/2018-07-31/201807311248455b443aad51b8d.png?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=M86xx6EY9QsGHHJuYSm0P5rKWyo%3D","video_length":"01:19","share":"0","username":"不奢求","avatar":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLC7DzvQy2G9ShM1kicx2RsIMgVIlL91UVvxwYQUZO1m2G5re6f02LCEiaLzwuOxIs6qgKgfLeve9Brw/132","is_star":0},{"id":31,"title":"小故事","media":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/videos/2018-07-31/20180731713slat6pdaaofrgpho.mp4?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=eefilhReMIyHylsoe4sJdooUTtI%3D","comments":"26","star":"3","like":"2","is_like":0,"uid":"8272553","created_at":"2018-07-31 11:50:49","address":"","cover":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/images/2018-07-31/20180731713slat6pdaaofrgpho.png?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=BxKzknI28GzAu9jv8ZP1q4JTAxA%3D","video_length":"04:16","share":"0","username":"cloud123","avatar":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/images/2018-08-02/201808020443275b621b6f4fe6b.png","is_star":0},{"id":316,"title":"test旋转","media":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/993c/201809/201809258dd70284c56a5000c7c04d3a88fc16e4.mp4?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=iysaM3BNZHMbksVGnLY9VvQYsPA%3D","comments":"1","star":"3","like":"4","is_like":0,"uid":"8272525","created_at":"2018-09-25 11:49:17","address":"","cover":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/993c/201809/201809258dd70284c56a5000c7c04d3a88fc16e4.png?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=UTowbbssmTEFYnjbL06JFYO4qCM%3D","video_length":"00:11","share":"1","username":"wengjf","avatar":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/993c/201808/201808268d48d1d96dff05c2dc5fa6e125a8415f.png","is_star":0},{"id":340,"title":"黄的","media":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/025a/201809/20180928056195b42df02a29e18972676c9f8102.mov?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779080&Signature=Sw8ys44QuNWtFdB4X9XWOwq14MQ%3D","comments":"4","star":"3","like":"3","is_like":0,"uid":"8272565","created_at":"2018-09-28 10:38:23","address":"","cover":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/025a/201809/20180928056195b42df02a29e18972676c9f8102.png?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779081&Signature=VOI3N2OxwSWy5rGykKxXlQlQHPs%3D","video_length":"00:23","share":"0","username":"何颀帅不+1","avatar":"http://ivy-test.oss-cn-shenzhen.aliyuncs.com/025a/201809/20180928e1b863c37852181c7d57d2e8462d3541.png","is_star":0},{"id":38,"title":"《西虹市首富》叫板《战狼2》56亿票房","media":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/videos/2018-07-31/20180731829j7lo3pvpkfuldviv.mp4?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779081&Signature=77zgOW%2BIjF%2FGq6VtM%2FThq3oaLYc%3D","comments":"130","star":"2","like":"0","is_like":0,"uid":"8272550","created_at":"2018-07-31 15:30:16","address":" ","cover":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/images/2018-07-31/20180731829j7lo3pvpkfuldviv.png?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779081&Signature=1DZADyOdOpz7XAJYL5VeMrTpLPY%3D","video_length":"02:04","share":"5","username":"Lambert","avatar":"http://thirdwx.qlogo.cn/mmopen/T8dbiaWKTNzzhvH4ib3J1SEgJtcJGhHbORwicHHhaZSpCibVAV07BMIXymtWBBR2Jczs5vzjRWWyeibKVPtQGfibz1jRWgxtDhJLqG/132","is_star":0},{"id":35,"title":"情侣","media":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/videos/2018-07-31/20180731i1ciydvhbg43d7nh2g8.mp4?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779081&Signature=AgQbOensh%2FoFfuyhc%2FXSRX6oTq8%3D","comments":"44","star":"2","like":"0","is_like":0,"uid":"8272549","created_at":"2018-07-31 12:41:00","address":"","cover":"http://ivystorage.oss-cn-shenzhen.aliyuncs.com/images/2018-07-31/20180731i1ciydvhbg43d7nh2g8.png?security-token=CAISlQJ1q6Ft5B2yfSjIr4nxeuiHtIlI54igc27yrm0TXOVYp4jtszz2IHBNdHduAuwWtf80mW1X6foYlqJ4T55IQ1Dza8J148yQFKwA5M6T1fau5Jko1beXewHKeSOZsebWZ%2BLmNqS%2FHt6md1HDkAJq3LL%2Bbk%2FMdle5MJqP%2B%2FEFA9MMRVv6F3kkYu1bPQx%2FssQXGGLMPPK2SH7Qj3HXEVBjt3gb6wZ24r%2FtxdaHuFiMzg%2B46JdM%2BN%2BgesD7P5E3bMsuCofk5oEsKPqdihw3wgNR6aJ7gJZD%2FTr6pdyHCzFTmU7WarqKrIYzfFQiPfVnRPEY9uKPnPl5q%2FHVkJ%2Fs1xFOMOdaXiLSXom8x9HeH%2BekJluivi134JemGoABk9S5KJkmMRPCvkp5IiYUNUoBHD%2BZtrRoKH5u5lsqqUJwInZjfISpXpNiVjttXYgd9EVoC2zZcDRwdu7p87lEV0JlXsHjZYwKgCBCc9v9d9R14%2FgBiCO3RsphaPPP9h1delnujnnxNJhJGhCQSE7ig7GDv4T8PZuG3M5yutxOG1U%3D&OSSAccessKeyId=STS.NJD1R3YViPJKqHCJmFPjtHMFQ&Expires=1541779081&Signature=p%2B4RP7YQuabzdIaFfztDEFVMQ%2FQ%3D","video_length":"02:27","share":"0","username":"不奢求","avatar":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLC7DzvQy2G9ShM1kicx2RsIMgVIlL91UVvxwYQUZO1m2G5re6f02LCEiaLzwuOxIs6qgKgfLeve9Brw/132","is_star":0}]
     * api_version : 1.1.0
     */

    @JSONField(name = "status")
    private int mStatus;
    @JSONField(name = "info")
    private String mInfo;
    @JSONField(name = "api_version")
    private String mApiVersion;
    @JSONField(name = "data")
    private List<MovieBean> mData;

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public String getInfo() {
        return mInfo;
    }

    public void setInfo(String info) {
        mInfo = info;
    }

    public String getApiVersion() {
        return mApiVersion;
    }

    public void setApiVersion(String apiVersion) {
        mApiVersion = apiVersion;
    }

    public List<MovieBean> getData() {
        return mData;
    }

    public void setData(List<MovieBean> data) {
        mData = data;
    }
}
