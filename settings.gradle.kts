rootProject.name = "upbit"

include("service")
include("service:spring:boot:starter")
include("token")

include("client:retrofit")
include("client:retrofit:spring:boot:autoconfigure")
