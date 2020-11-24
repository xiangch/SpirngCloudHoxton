package cn.com.do1cloud.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TenantService {
    @Value("${tenantId:DO1}")
    private String tenantId;
    public String getTenantId(){
        return tenantId;
    }
}
