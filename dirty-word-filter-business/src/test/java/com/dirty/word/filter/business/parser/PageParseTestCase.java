package com.dirty.word.filter.business.parser;

import com.dirty.word.filter.business.parser.PageParse;
import com.dirty.word.filter.business.util.HttpUtil;
import com.dirty.word.filter.model.Category;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;


/**
 * Created by shj on 2017/7/28.
 */
public class PageParseTestCase {
    private PageParse pageParse;


    @Before
    public void init(){
        System.setProperty("global.config.path","/Users/shj/dev/env/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dirty-word-filter-business/spring-service.xml");
        this.pageParse = (PageParse) applicationContext.getBean("pageParseImpl");
    }

    @Test
    public void testParse(){
        String htmlStr = "<!DOCTYPE html>\n" +
                "<HTML>\n" +
                "<head><meta http-equiv='Content-Type' content='text/html; charset=gb2312'>\n" +
                "<link rel=stylesheet type=text/css href='/images/oras.css'></head>\n" +
                "<script src=/function.js></script>\n" +
                "<body topmargin=0 leftmargin=0>\n" +
                "<table width=\"100%\" border=0 cellpadding=0 cellspacing=0>\n" +
                "<td><form name=form1 action=bbsdoc>\n" +
                "<tr><td height=30 colspan=2>\n" +
                "<table width=\"100%\"  border=0 cellspacing=0 cellpadding=0>\n" +
                "<tr><td width=40><img src=\"/images/spacer.gif\" width=40 height=10 alt=\"\"></td>\n" +
                "<td><table width=\"100%\" border=0 align=right cellpadding=0 cellspacing=0>\n" +
                "<tr><td><a href=boa?secstr=1 target=f3>交通大学</a> / <a href=home?B=XJTUnews target=f3>XJTUnews版</a>&nbsp;<a href=\"http://bbs.xjtu.edu.cn/BMY/rss?board=XJTUnews\" target=\"blank\"><img  src=\"/images/rss.gif\" border=\"0\" /></a></td></tr></table></td>\n" +
                "<td><table border=0 align=right cellpadding=0 cellspacing=0>\n" +
                "<tr><td>版主[<a href=qry?U=alexaustin>alexaustin</a> <a href=qry?U=jxchz>jxchz</a>]</td></tr>\n" +
                "</table></td></tr></table></td></tr>\n" +
                "<tr><td height=70 colspan=2>\n" +
                "<table width=\"100%\" border=0 cellpadding=0 cellspacing=0 class=\"level2\">\n" +
                "<tr><td width=40>&nbsp;</td><td height=70>\n" +
                "<table width=\"95%\"  border=0 cellpadding=0 cellspacing=0>\n" +
                "<tr><td colspan=2 valign=bottom>\n" +
                "<table width=\"100%\" border=0 cellpadding=0 cellspacing=0>\n" +
                "<tr><td><div class=\"menu\">\n" +
                "<div class=btncurrent>&lt;说说咱交大&gt;</div>\n" +
                "<a class=btnlinkgrey href=\"not?B=XJTUnews&mode=3\" title=\"版面简介 accesskey: d\" accesskey=\"d\">&lt;版面简介&gt;</a>\n" +
                "<a class=btnlinkgrey href=\"not?B=XJTUnews&mode=1\" title=\"备忘录 accesskey: w\" accesskey=\"w\">&lt;备忘录&gt;</a>\n" +
                "<a class=btnlinkgrey href=\"gdoc?B=XJTUnews\" title=\"文摘区 accesskey: g\" accesskey=\"g\">&lt;文摘区&gt;</a>\n" +
                "<a class=btnlinkgrey href=\"mmdoc?B=XJTUnews\" title=\"被M文章 accesskey: m\" accesskey=\"m\">&lt;被M文章&gt;</a>\n" +
                "<a class=btnlinkgrey href=\"bknsel?B=XJTUnews\">&lt;过刊区&gt;</a>\n" +
                "<a class=btnlinkgrey href=\"0an?path=/groups/GROUP_1/XJTUnews\" title=\"精华区 accesskey: x\" accesskey=\"x\">&lt;精华区&gt;</a>\n" +
                "<a class=btnfunc href=\"brdadd?B=XJTUnews\" title=\"预定本版 accesskey: a\" accesskey=\"a\"> 预定本版</a>\n" +
                "<a class=btnfunc href=\"bfind?B=XJTUnews\" title=\"版内查询 accesskey: s\" accesskey=\"s\"> 版内查询</a>\n" +
                "</div></td></tr></table></td></tr>\n" +
                "<tr><td><a href=\"pst?B=XJTUnews\" class=\"btnsubmittheme\" title=\"我要发表文章 accesskey: p\" accesskey=\"p\">我要发表文章</a>\n" +
                "文章数[122363] 在线[24]</td><td align=right><a href=\"tdoc?B=XJTUnews\">主题模式</a>\n" +
                "<a href=\"clear?B=XJTUnews&S=122344\">清除未读</a> <a href=# onclick='javascript:{location=location;return false;}'>刷新</a>\n" +
                "<a href=\"doc?B=XJTUnews&S=1\" title=\"第一页 accesskey: 1\" accesskey=\"1\">第一页</a>\n" +
                "<a href=\"doc?B=XJTUnews&S=122324\" title=\"上一页 accesskey: f\" accesskey=\"f\">上一页</a>\n" +
                "<a href=\"doc?B=XJTUnews&S=122344\" title=\"最后一页 accesskey: l\" accesskey=\"l\">最后一页</a>\n" +
                "<input type=hidden name=B value=XJTUnews><input name=Submit1 type=Submit class=sumbitgrey value=Go>\n" +
                "<input name=S type=text style=\"font-size:11px;font-family:verdana;\" size=4>\n" +
                " Page: 6119/6119\n" +
                "</td></tr></table></td></tr></form>\n" +
                "</table></td><table width='80%' align=\"center\" > <tr><td><font color='red'>HOT</font></td><td><a href='tfind?B=XJTUnews&amp;th=1501052286'>致 Imziyouguang 同学</a></td><td>[讨论人数:36] </td></tr>\n" +
                " </table><div class=\"linehr\"></div><tr><td class=\"level1\"><TABLE width=\"95%\" cellpadding=2 cellspacing=0 align=\"center\" >\n" +
                "<TBODY>\n" +
                "<TR>\n" +
                "<TD class=tdtitle>序号</TD>\n" +
                "<TD class=tdtitle>状态</TD>\n" +
                "<TD class=tduser>作者</TD>\n" +
                "<TD align=center class=tdtitle>日期</TD>\n" +
                "<TD align=center class=tdtitle>标题</TD>\n" +
                "<TD class=tdtitle>星级</TD>\n" +
                "<TD class=tdtitle>评价</TD>\n" +
                "</TR>\n" +
                "<tr class=d0><td class=tdborder>122344</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=xxpmc>xxpmc</a></td><td align=center class=tdborder><NOBR>Jul 28 17:31</NOBR></td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501234308.A&N=122344&T=0  >Re: 致xxpmc同学 </a>(<font class=tea>305字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr><td class=tdborder>122345</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=ffddmm>ffddmm</a></td><td align=center class=tdborder>Jul 28 17:38</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501234701.A&N=122345&T=0  >Re: 前两天回了趟交大 </a>(<font class=tea>6字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr class=d0><td class=tdborder>122346</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=xxpmc>xxpmc</a></td><td align=center class=tdborder>Jul 28 17:38</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501234724.A&N=122346&T=0  >Re: 致 Imziyouguang 同学 </a>(<font class=tea>213字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr><td class=tdborder>122347</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=nic>nic</a></td><td align=center class=tdborder>Jul 28 18:28</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501237693.A&N=122347&T=-9  >○ 就事论事，请不要恶意攻击他人 </a>(<font class=tea>28字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr class=d0><td class=tdborder>122348</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=guofengxian>guofengxian</a></td><td align=center class=tdborder>Jul 28 18:35</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501238156.A&N=122348&T=0  >Re: 致 Imziyouguang 同学 </a>(<font class=tea>77字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr><td class=tdborder>122349</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=lusu>lusu</a></td><td align=center class=tdborder>Jul 28 18:40</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501238428.A&N=122349&T=0  >Re: 致xxpmc同学 </a>(<font class=tea>391字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr class=d0><td class=tdborder>122350</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=niaomingshan>niaomingshan</a></td><td align=center class=tdborder>Jul 28 18:54</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501239299.A&N=122350&T=0  >Re: 致 Imziyouguang 同学 </a>(<font class=tea>67字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr><td class=tdborder>122351</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=xxpmc>xxpmc</a></td><td align=center class=tdborder>Jul 28 18:58</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501239503.A&N=122351&T=0  >Re: 致xxpmc同学 </a>(<font class=tea>270字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr class=d0><td class=tdborder>122352</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=niaomingshan>niaomingshan</a></td><td align=center class=tdborder>Jul 28 19:03</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501239815.A&N=122352&T=0  >Re: 致 Imziyouguang 同学 </a>(<font class=tea>28字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr><td class=tdborder>122353</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=xxpmc>xxpmc</a></td><td align=center class=tdborder>Jul 28 19:06</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501239976.A&N=122353&T=0  >Re: 致 Imziyouguang 同学 </a>(<font class=tea>90字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr class=d0><td class=tdborder>122354</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=Imziyouguang>Imziyouguang</a></td><td align=center class=tdborder>Jul 28 19:11</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501240271.A&N=122354&T=0  >○ [转载] 给岁月以文明，而非给文明以岁月 </a>(<font class=red>5.3千字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr><td class=tdborder>122355</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=xxpmc>xxpmc</a></td><td align=center class=tdborder>Jul 28 19:21</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501240870.A&N=122355&T=0  >Re: [转载] 给岁月以文明，而非给文明以岁月 </a>(<font class=tea>213字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr class=d0><td class=tdborder>122356</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=lusu>lusu</a></td><td align=center class=tdborder>Jul 28 19:25</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501241136.A&N=122356&T=0  >Re: 致xxpmc同学 </a>(<font class=tea>391字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr><td class=tdborder>122357</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=sleepless>sleepless</a></td><td align=center class=tdborder>Jul 28 19:29</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501241393.A&N=122357&T=0  >Re: [转载] 给岁月以文明，而非给文明以岁月 </a>(<font class=tea>19字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr class=d0><td class=tdborder>122358</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=naittian>naittian</a></td><td align=center class=tdborder>Jul 28 20:07</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501243662.A&N=122358&T=0  >Re: 关于前面帖子的一些澄清声明 </a>(<font class=tea>3字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr><td class=tdborder>122359</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=anwinchina>anwinchina</a></td><td align=center class=tdborder>Jul 28 20:25</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501244755.A&N=122359&T=0  >Re: 支持严教Re: 正告杜亚平教授、雷波教授和前沿院 </a>(<font class=tea>138字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr class=d0><td class=tdborder>122360</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=anwinchina>anwinchina</a></td><td align=center class=tdborder>Jul 28 20:44</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501245850.A&N=122360&T=0  >Re: 正告杜亚平教授、雷波教授和前沿院 </a>(<font class=tea>17字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr><td class=tdborder>122361</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=liyangfirst>liyangfirst</a></td><td align=center class=tdborder>Jul 28 20:54</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501246443.A&N=122361&T=0  >Re: 致 Imziyouguang 同学 </a>(<font class=tea>14字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr class=d0><td class=tdborder>122362</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=xxpmc>xxpmc</a></td><td align=center class=tdborder>Jul 28 20:58</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501246695.A&N=122362&T=0  >Re: 致xxpmc同学 </a>(<font class=tea>287字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr><td class=tdborder>122363</td><td class=tdborder>N</td><td class=tduser><a href=qry?U=Vincent>Vincent</a></td><td align=center class=tdborder>Jul 28 21:01</td><td class=tdborder ><a href=con?B=XJTUnews&F=M.1501246860.A&N=122363&T=0  >Re: 致 Imziyouguang 同学 </a>(<font class=tea>226字</font>)</td><td class=tdborder>0</td><td class=tdborder>0人</td>\n" +
                "<tr class='doctop'><td class='tdborder doctopword'>提示</td>\n" +
                "<td class='tdborder'>B</td><td class='tduser'><a href=qry?U=jxchz>jxchz</a></td><td align=center class='tdborder'>Jan 22 15:20</td><td class='tdborder'><a href=con?B=XJTUnews&F=M.1421911201.A class=1103>● 交大生活指南</a></td>\n" +
                "<td class='tdborder'>&nbsp;</td><td class='tdborder'>&nbsp;</td></tr><tr class='doctop'><td class='tdborder doctopword'>提示</td>\n" +
                "<td class='tdborder'>N@</td><td class='tduser'><a href=qry?U=nic>nic</a></td><td align=center class='tdborder'>Mar 28 18:34</td><td class='tdborder'><a href=con?B=XJTUnews&F=M.1490697251.A class=1103>● 档案馆关于拍摄收集2017年毕业合影档案的通知</a></td>\n" +
                "<td class='tdborder'>&nbsp;</td><td class='tdborder'>&nbsp;</td></tr><tr class='doctop'><td class='tdborder doctopword'>提示</td>\n" +
                "<td class='tdborder'>N</td><td class='tduser'><a href=qry?U=nic>nic</a></td><td align=center class='tdborder'>Jul 23 15:39</td><td class='tdborder'><a href=con?B=XJTUnews&F=M.1500795573.A class=1103>● [转载] 关于新生报到期间加强校园环境管理的通知</a></td>\n" +
                "<td class='tdborder'>&nbsp;</td><td class='tdborder'>&nbsp;</td></tr><tr class='doctop'><td class='tdborder doctopword'>提示</td>\n" +
                "<td class='tdborder'>N</td><td class='tduser'><a href=qry?U=ruoqing>ruoqing</a></td><td align=center class='tdborder'>Jul 23 08:58</td><td class='tdborder'><a href=con?B=XJTUnews&F=M.1500771521.A class=1103>● 【转】关于2017年暑期后勤保障部服务安排的通知</a></td>\n" +
                "<td class='tdborder'>&nbsp;</td><td class='tdborder'>&nbsp;</td></tr></TR> </TBODY></TABLE></td></tr>\n" +
                "<tr><td height=40 class=\"level1\"><TD class=level1 width=40>&nbsp;</TD>\n" +
                "<table width=\"95%\"  border=0 cellpadding=0 cellspacing=0 class=\"level1\" align=\"center\">\n" +
                "<td><form name=form2 action=bbsdoc>\n" +
                "<tr><td><a href=\"pst?B=XJTUnews\" class=btnsubmittheme>我要发表文章</a>\n" +
                "文章数[122363] 在线[24]</td>\n" +
                "<td align=\"right\"><a href=\"tdoc?B=XJTUnews\">主题模式</a>\n" +
                "<a href=\"clear?B=XJTUnews&S=122344\">清除未读</a> <a href=# onclick='javascript:{location=location;return false;}'>刷新</a>\n" +
                "<a href=\"doc?B=XJTUnews&S=1\">第一页</a>\n" +
                "<a href=\"doc?B=XJTUnews&S=122324\">上一页</a>\n" +
                "<a href=\"doc?B=XJTUnews&S=122344\">最后一页</a>\n" +
                "<input type=hidden name=B value=XJTUnews><input name=Submit2 type=Submit class=sumbitgrey value=Go>\n" +
                "<input name=S type=text style=\"font-size:11px;font-family:verdana;\" size=4></td>\n" +
                "</tr></form></table></td></tr>\n" +
                "</td></table></td></tr><table width=\"100%\" cellpadding=2 cellspacing=0><tr><td class=tdtitle align=center>\n" +
                "本版关键字: <a href=bbssbs?keyword=尊重网友 target=f3>尊重网友</a> &nbsp;<a href=bbssbs?keyword=尊重自己 target=f3>尊重自己</a> &nbsp;<a href=bbssbs?keyword=理性灌水 target=f3>理性灌水</a> &nbsp;<a href=bbssbs?keyword=勤看置底 target=f3>勤看置底</a> &nbsp;</td></tr></table>\n" +
                "</table></body>\n";
        Document document = Jsoup.parse(htmlStr);
        Elements elements =document.getElementsByAttributeValue("width","95%");
//        System.out.println(element.html());
//        document table = Jsoup.parse(element.html());
        Elements elementTemp = elements.get(1).children().get(0).children();
        System.out.println(elementTemp.get(1).children().get(4).getElementsByTag("a").get(0).attr("href"));

//        for (Element e:elementsTemp){
//            System.out.println(e.html());
//            System.out.println("next.....");
//        }
    }


    @Test
    public void testItemPageParse(){
        String html = "<!DOCTYPE html>\n" +
                "<HTML>\n" +
                "    <head>\n" +
                "        <meta http-equiv='Content-Type' content='text/html; charset=gb2312'>\n" +
                "        <link rel=stylesheet type=text/css href='/images/oras.css'>\n" +
                "    </head>\n" +
                "    <title>Re: 致 Imziyouguang 同学 | 兵马俑BBS</title>\n" +
                "    <script src='/function.js'></script>\n" +
                "</head>\n" +
                "<body leftmargin=0 topmargin=0>\n" +
                "    <img src=\"/images/bmy.gif\" style=\"position: absolute;top:-160px;\"/>\n" +
                "    <table width=\"100%\" border=0 cellpadding=0 cellspacing=0>\n" +
                "        <tr>\n" +
                "            <td height=30 colspan=2>\n" +
                "                <table width=\"100%\"  border=0 cellspacing=0 cellpadding=0>\n" +
                "                    <tr>\n" +
                "                        <td width=40>\n" +
                "                            <img src=\"/images/spacer.gif\" width=40 height=10 alt=\"\">\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <table width=\"100%\" border=0 align=right cellpadding=0 cellspacing=0>\n" +
                "                                <tr>\n" +
                "                                    <td>\n" +
                "                                        <a href=\"boa?secstr=1\">交通大学</a> /\n" +
                "                                        <a href=\"home?B=XJTUnews\">XJTUnews</a> / 阅读文章\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </table>\n" +
                "                        </td>\n" +
                "                        <td>\n" +
                "                            <table border=0 align=right cellpadding=0 cellspacing=0>\n" +
                "                                <tr>\n" +
                "                                    <td> 版主 \n" +
                "                                        <a href=qry?U=alexaustin>alexaustin</a>\n" +
                "                                        <a href=qry?U=jxchz>jxchz</a>\n" +
                "                                    </tr>\n" +
                "                                </table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td height=70 colspan=2>\n" +
                "                    <table width=\"100%\" height=\"100%\" border=0 cellpadding=0 cellspacing=0 bgcolor=#efefef>\n" +
                "                        <tr>\n" +
                "                            <td width=40>&nbsp; </td>\n" +
                "                            <td height=70>\n" +
                "                                <table width=\"95%\" height=\"100%\"  border=0 cellpadding=0 cellspacing=0>\n" +
                "                                    <tr>\n" +
                "                                        <td colspan=2 valign=bottom>\n" +
                "                                            <table width=\"100%\" border=0 cellpadding=0 cellspacing=0>\n" +
                "                                                <tr>\n" +
                "                                                    <td>\n" +
                "                                                        <div class=\"menu\">\n" +
                "                                                            <DIV class=btncurrent>&lt;说说咱交大&gt;</DIV>\n" +
                "                                                            <A href='fwd?B=XJTUnews&amp;F=M.1501238156.A' class=btnfunc>/ 转寄</A>\n" +
                "                                                            <DIV>\n" +
                "                                                                <A href='ccc?B=XJTUnews&amp;F=M.1501238156.A' class=btnfunc>/ 转贴\n" +
                "                                                                </a>\n" +
                "                                                                <a href='pstmail?B=XJTUnews&amp;F=M.1501238156.A&amp;num=122347' class=btnfunc title=\"回信给作者 accesskey: m\" accesskey=\"m\">/ 回信给作者</a>\n" +
                "                                                                <a href='tfind?B=XJTUnews&amp;th=1501052286&amp;T=致%20Imziyouguang%20同学' class=btnfunc>/ 同主题列表</a>\n" +
                "                                                                <a href='bbstcon?board=XJTUnews&amp;start=122347&amp;th=1501052286' class=btnfunc>/ 同主题由此展开</a>\n" +
                "                                                                <a href='home?B=XJTUnews&amp;S=122343' class=btnfunc title=\"返回讨论区 accesskey: b\" accesskey=\"b\">/ 返回讨论区</a>\n" +
                "                                                            </div>\n" +
                "                                                        </td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                        <tr>\n" +
                "                                            <td width=\"60%\">\n" +
                "                                                <a href='pst?B=XJTUnews&amp;F=M.1501238156.A&amp;num=122347' class=btnsubmittheme title=\"回复本文 accesskey: r\" accesskey=\"r\">回复本文</a>\n" +
                "                                            </td>\n" +
                "                                            <td width=\"40%\" align=right>分享到 \n" +
                "                                                <a href=\"#\" onclick=\"javascript:share('sina','Re%3A%20%E8%87%B4%20Imziyouguang%20%E5%90%8C%E5%AD%A6','XJTUnews','M.1501238156.A');\">\n" +
                "                                                    <img src=\"/images/share-sina.png\"/>\n" +
                "                                                </a>\n" +
                "                                                <a href=\"#\" onclick=\"javascript:share('renren','Re%3A%20%E8%87%B4%20Imziyouguang%20%E5%90%8C%E5%AD%A6','XJTUnews','M.1501238156.A');\">\n" +
                "                                                    <img src=\"/images/share-rr.png\"/>\n" +
                "                                                </a>\n" +
                "                                                <a href=\"#\" onclick=\"javascript:share('tencent','Re%3A%20%E8%87%B4%20Imziyouguang%20%E5%90%8C%E5%AD%A6','XJTUnews','M.1501238156.A');\">\n" +
                "                                                    <img src=\"/images/share-tencent.png\"/>\n" +
                "                                                </a> |\n" +
                "                                                <a href='con?B=XJTUnews&amp;F=M.1501237693.A&amp;N=122347&amp;T=18446744073709551607' title=\"上篇 accesskey: f\" accesskey=\"f\">上篇 </a>\n" +
                "                                                <a href='home?B=XJTUnews&amp;S=122343' title=\"本讨论区 accesskey: c\" accesskey=\"c\">本讨论区 </a>\n" +
                "                                                <a href='con?B=XJTUnews&amp;F=M.1501238428.A&amp;N=122349&amp;T=0' title=\"下篇 accesskey: n\" accesskey=\"n\">下篇</a>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td width=40 class=\"level1\">&nbsp;</td>\n" +
                "                                <td class=\"level1\">\n" +
                "                                    <br>\n" +
                "                                    <TABLE width=\"95%\" cellpadding=5 cellspacing=0>\n" +
                "                                        <TBODY>\n" +
                "                                            <tr>\n" +
                "                                                <td class=tdtitletheme>&nbsp;</td>\n" +
                "                                            </tr>\n" +
                "                                            <tr>\n" +
                "                                                <td class=\"bordertheme\">\n" +
                "                                                    <div id='filecontent' style='width:800px;'>\n" +
                "发信人: guofengxian (火柴天堂), 信区: XJTUnews\n" +
                "\n" +
                "                                                        <br>标 &nbsp;题: Re: 致 Imziyouguang 同学\n" +
                "\n" +
                "                                                        <br>发信站: 兵马俑BBS (Fri Jul 28 18:35:56 2017), 本站(bbs.xjtu.edu.cn)\n" +
                "\n" +
                "                                                        <br>\n" +
                "                                                        <br>大多数学生都是需要push的，杜老师他们课题组的出发点我很支持，但是可以再人性化一些。惩罚太严苛，要给学生一定的自由时间，非工作时间随叫随到太强人所难。\n" +
                "\n" +
                "                                                        <br>\n" +
                "                                                        <br>\n" +
                "                                                        <br>【 在 xxpmc 的大作中提到: 】\n" +
                "\n" +
                "                                                        <br>\n" +
                "                                                        <font color=808080>: 我给你讲一下我以前课题组的实例吧，我们课题组也出过类似的规定\n" +
                "\n" +
                "                                                            <br>: \n" +
                "\n" +
                "                                                            <br>: 一开始导师定的九点到实验室，然后学生们基本都是九点半十点才到实验室\n" +
                "\n" +
                "                                                            <br>: \n" +
                "\n" +
                "                                                            <br>: 后来导师要求早上八点半到实验室，基本上九点九点半学生们才陆陆续续来实验室\n" +
                "\n" +
                "                                                            <br>: \n" +
                "\n" +
                "                                                            <br>: 如果真的有健身放松压力太大之类的问题，可以直接找导师商量，在完成工作量的情况下，一般导师不会拒绝学生的合理要求。\n" +
                "\n" +
                "                                                            <br>: \n" +
                "\n" +
                "                                                            <br>: 实验室里就十几个人，真有问题围在一起开个会讨论一下，啥都解决了，和那种几千几万人的企业里面定的规章制度能是一回事么？\n" +
                "\n" +
                "                                                            <br>: \n" +
                "\n" +
                "                                                            <br>: (以下引言省略...)\n" +
                "\n" +
                "                                                            <br>\n" +
                "                                                        </font>\n" +
                "                                                        <br>\n" +
                "                                                        <div class=\"con_sig\">--\n" +
                "\n" +
                "                                                            <br>\n" +
                "                                                            <font class=h35>※ 来源:．兵马俑BBS \n" +
                "                                                                <a target=_blank href='http://bbs.xjtu.edu.cn'>http://bbs.xjtu.edu.cn</a>&nbsp;[FROM: 115.154.43.70]\n" +
                "                                                            </font>\n" +
                "                                                            <font class=b40>\n" +
                "                                                                <font class=c37>\n" +
                "                                                                </div>\n" +
                "                                                            </div>\n" +
                "                                                        </td>\n" +
                "                                                    </TR>\n" +
                "                                                </TBODY>\n" +
                "                                            </TABLE>\n" +
                "                                            <br>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    <tr>\n" +
                "                                        <td></td>\n" +
                "                                        <td height=\"20\" valign=\"middle\">本文链接&nbsp;&nbsp;\n" +
                "                                            <a href=' http://bbs.xjtu.edu.cn/BMY/con?B=XJTUnews&F=M.1501238156.A'>http://bbs.xjtu.edu.cn/BMY/con?B=XJTUnews&F=M.1501238156.A</a>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                </table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "        <br />\n" +
                "        <script>eva('XJTUnews','M.1501238156.A');</script>\n" +
                "    </body>\n" +
                "</html>";
        Document document = Jsoup.parse(html);
        Element element = document.getElementById("filecontent");
        Elements elements= element.children();
        System.out.println(element.ownText());

    }

    @Test
    public void testTimeFormat()throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd HH:mm", Locale.ENGLISH);
        Date date = simpleDateFormat.parse("Jul 28 17:31");
        System.out.println(date);
    }

    @Test
    public void testHtmlParse()throws Exception{
        Category category = new Category();
        category.setUrl("http://bbs.xjtu.edu.cn/BMYAELVMOCZRGMXLVXJIQLJXLFSQUSEPTPOB_B/");
        category.setParam("home?B=XJTUnews");
        category.setName("说说咱交大");
        category.setId(1);
        System.out.println(this.pageParse.htmlParse(HttpUtil.httpGetExecute(HttpUtil.httpGetPackage(category.getUrl()+category.getParam())),category.getUrl(),category.getId()));;


    }


    @Test
    public void testString()throws Exception{
        String [] str = new String("你好董昭").split("");
        for(String s:str){
            System.out.println(s);
        }

        HashMap<String,Integer> testMap = new HashMap<String, Integer>();
        for(String s:str){
            testMap.put(s,1);
        }
        System.out.println(testMap.containsKey(new String("董")));


    }


}
