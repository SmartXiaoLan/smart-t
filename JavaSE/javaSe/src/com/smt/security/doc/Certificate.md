#Java安全之证书工具KEYTOOL的使用

生成证书：`keytool -genkeypair -keystore [文件名称] -alias [密钥别名]`

公钥证书：`keytool -exportcert -keystore [私钥文件] -alias [密钥别名] -file [文件名称]`

Jarsigner工具只负责对jar进行签名

签名jar文件：`jarsigner -keystore [证书文件] [签名的jar文件] [密钥别名]`

验证文件：`jarsigner -verify -keystore [公钥证书] [检验的jar文件]`