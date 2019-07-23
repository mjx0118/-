package com.qf.web;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Bills;
import com.qf.bean.Billtype;
import com.qf.service.BillsMapperService;
import com.qf.service.BilltypeMapperService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Controller
public class BillsController {
    @Resource
    private BilltypeMapperService billtypeMapperService;
    @Resource
    private BillsMapperService billsMapperService;

    /**
     * 查询所有账单
     */


    @RequestMapping("/getbills")
    public String getbills(@RequestParam(defaultValue = "-1") int typeid , @RequestParam(defaultValue = "2019/02/03") Date billtime, @RequestParam(defaultValue = "2019/12/08")Date lasttime, @RequestParam(defaultValue = "1") int index, ModelMap map) {
        List<Billtype> billtypes = billtypeMapperService.findall();
        map.addAttribute("tbill", billtypes);
        PageInfo<Bills> pageInfo = billsMapperService.getbills(index, 2,typeid, billtime, lasttime);
        map.addAttribute("pi", pageInfo);
        map.addAttribute("typeid", typeid);
        map.addAttribute("billtime", billtime);
        map.addAttribute("lsttime", lasttime);
        return "show";
    }







    /**
     * 删除
     */
    @RequestMapping("/delete")
    public void delete(int id, HttpServletResponse response) {
        int i = billsMapperService.deleteByPrimaryKey(id);
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if (i > 0) {
                out.print("<script>alert('删除成功');location.href='getbills'</script>");
            } else {
                out.print("<script>alert('删除失败');location.href='getbills'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 记账
     */
    @RequestMapping("/gettype")
    public String gettpe(ModelMap map) {
        List<Billtype> billtypes = billtypeMapperService.findall();
        map.addAttribute("tlist", billtypes);
        return "add";
    }
    @RequestMapping("/add")
   // @Transactional
    public void add(Bills bills, HttpServletResponse response){
        bills.setBilltime(new Date());
       bills.setTypeid(2);
        try {
            int i = billsMapperService.insertSelective(bills);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if(i>0){
                out.print("<script>alert('新增成功');location.href='getbills'</script>");
            }else{
                out.print("<script>alert('新增失败');location.href='getbills'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 修改
     */
    @RequestMapping("/getypesupdate")
    public String getbillbyid(int id, ModelMap map) {
        List<Billtype> billtypes = billtypeMapperService.findall();
        Bills bills = billsMapperService.selectByPrimaryKey(id);
        map.addAttribute("billss",billtypes);
        map.addAttribute("bills", bills);
        return "update";
    }
    @RequestMapping("/update")
    public void update(Bills bills, HttpServletResponse response) {
        int i = billsMapperService.updateByPrimaryKeySelective(bills);
        PrintWriter writer = null;
        try {
            response.setContentType("text/html;charset=utf-8");
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (i > 0) {
            writer.print("<script>alert('修改成功');location.href='getbills'</script>");
        } else {
            writer.print("<script>alert('修改失败');location.href='getbills'</script>");
        }

    }
}



