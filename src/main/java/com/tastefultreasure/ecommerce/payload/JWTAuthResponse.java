package com.tastefultreasure.ecommerce.payload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
	
	private String accessToken;
	private String email;
    private String tokenType = "Bearer";

    // Getter for accessToken
    public String getAccessToken() {
        return accessToken;
    }

    // Setter for accessToken
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    // Getter for tokenType
    public String getTokenType() {
        return tokenType;
    }

    // Setter for tokenType
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    
    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for tokenType
    public void setEmail(String email) {
        this.email = email;
    }

}
