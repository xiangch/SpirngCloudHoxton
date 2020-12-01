package cn.com.do1cloud.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TenantService {
    @Value("${tenantId:bb01a3cd987f469d9e0f04dffa2d3278}")
    private String tenantId;
    public String getTenantId(){
        return tenantId;
    }
}
