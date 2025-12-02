#!groovy

import jenkins.model.*
import hudson.security.*

println("=== Running Security Setup Script ===")

def instance = Jenkins.getInstance()

def realm = new HudsonPrivateSecurityRealm(false)
realm.createAccount("admin", "admin123")
instance.setSecurityRealm(realm)

instance.setAuthorizationStrategy(new FullControlOnceLoggedInAuthorizationStrategy())
instance.save()

println("=== Admin user created: admin/admin123 ===")
