package com.employee.Work_Mode.Controller;
import com.employee.Work_Mode.Security.JwtUtil;
import com.employee.Work_Mode.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AutheC {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername, authenticationRequest.getPassword())
        );

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        return jwtUtil.generateToken(userDetails);
    }

    static class AuthenticationRequest {
        public Object getUsername;
        private String name;
        private String password;

        public Object getGetUsername() {
            return getUsername;
        }

        public void setGetUsername(Object getUsername) {
            this.getUsername = getUsername;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return null;
        }
    }
}
