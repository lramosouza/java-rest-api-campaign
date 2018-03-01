package br.com.campaigns.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import br.com.campaigns.api.config.SwaggerConfig;

@SpringBootApplication
public class CampaignApplication {
    public static void main(String[] args) {
    	new SpringApplicationBuilder(SwaggerConfig.class).run(args);
    }
}