export const oktaConfig = {
    clientId: process.env.REACT_APP_CLIENT_ID,
    issuer: process.env.REACT_APP_ISSUER,
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true,
}