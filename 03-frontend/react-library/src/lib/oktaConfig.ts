export const oktaConfig = {
    clientId: '0oajz0jns37u9En135d7',
    issuer: 'https://dev-85292631.okta.com/oauth2/default',
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true,
}