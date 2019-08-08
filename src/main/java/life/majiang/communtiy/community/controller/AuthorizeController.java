package life.majiang.communtiy.community.controller;


import life.majiang.communtiy.community.dto.AccessTokenDTO;
import life.majiang.communtiy.community.dto.GithubUser;
import life.majiang.communtiy.community.mapper.UserMapper;
import life.majiang.communtiy.community.model.User;
import life.majiang.communtiy.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("1932cdd507ac56a69332")
    private String clientId;
    @Value("b9e8a433b05950133ef7b078658a759384120afb")
    private String clientSecret;
    @Value("http://localhost:8080/callback")
    private String redireUri;
    @GetMapping("/callback")

    @Autowired
    private UserMapper userMapper;
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                            HttpServletRequest request){
        AccessTokenDTO accessTokenDTO =new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redireUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser =githubProvider.getUser(accessToken);
        System.out.println(githubUser.getName());
        System.out.println(githubUser.getBio());

        if(githubUser !=null){
            User user=new User;
            user.
            userMapper.insert(user);
            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
            //登录成功，写cookie和 session
        }
        else{
            return "redirect:/";
            //登录失败，重新登录
        }

    }
}
