package cn.bigff.controller;

import cn.bigff.domain.UserPO;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("/testAjax")
    public @ResponseBody
    UserPO testAjax(){
        UserPO userPO = new UserPO();
        userPO.setUsername("bigff");

        return userPO;
    }

    @PostMapping("file")
    public String fileUp(HttpServletRequest request, MultipartFile file) throws Exception{

        if (!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/static/img");
            //上传文件名
            String filename=file.getOriginalFilename();
            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            //将用户添加到model
        }
        return "result";

    }


    @GetMapping("/download/{fileName}/{nouse}")
    public ResponseEntity<byte[]> download(@PathVariable String fileName, @PathVariable String nouse) {
        //依据文件名构建本地文件路径
        String filePath = "D:\\Temp\\"+fileName;
        //依据文件路径构建File对象
        File file = new File(filePath);
        //创建响应头对象，设置响应信息
        HttpHeaders headers = new HttpHeaders();
        try {
            //对文件名进行重新编码，防止在响应头中出现中文乱码
            String headerFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            //设置响应内容处理方式为附件,并指定文件名
            headers.setContentDispositionFormData("attachment", headerFileName);
            //设置响应头类型为application/octet-stream,表示是一个流类型
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //将文件转换成字节数组
            byte[] bytes = FileUtils.readFileToByteArray(file);
            //创建ResponseEntity对象（封装文件字节数组、响应头、响应状态码）
            ResponseEntity<byte[]> entity = new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
            //最后将整个ResponseEntity对象返回给DispatcherServlet
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("文件下载失败");
        }
    }



}
