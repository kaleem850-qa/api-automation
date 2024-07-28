#### Given Steps

Gherkin Expressions|Example
--- | ---
**Given** User set {} header to {}|**Given** User set `Content-Type` header to `application/json`
**Given** User set headers to|**Given** User set headers to <br>&emsp;&emsp;&#124;`key`&emsp;&emsp;&emsp;&emsp;&nbsp;&#124;`value`&emsp;&emsp;&emsp;&emsp;&#124;<br>&emsp;&emsp;&#124;Content-Type&nbsp;&#124;application/json&nbsp;&#124;<br>&emsp;&emsp;&#124;Accept&emsp;&emsp;&emsp;&nbsp;&#124;application/json&nbsp;&#124;
**Given** User set cookie to {}|**Given** User set cookie to `cookieName=value1`
**Given** User set {} cookie to {}|**Given** User set `cookieName` cookie to `value1`
**Given** User set cookies to|**Given** User set cookies to<br>&emsp;&emsp;&#124;`key`&emsp;&emsp;&emsp;&emsp;&#124;`value`&emsp;&#124;<br>&emsp;&emsp;&#124;cookieName&nbsp;&nbsp;&#124;value1&emsp;&nbsp;&#124;<br>&emsp;&emsp;&#124;cookieName&nbsp;&nbsp;&#124;value2&emsp;&#124;
**Given** User set basic authentication to {} and {}|**Given** User set basic authentication to `username` and `password`
**Given** User set form authentication to {} and {}|**Given** User set form authentication to `username` and `password`
**Given** User set preemptive authentication to {} and {}|**Given** User set preemptive authentication to `username` and `password`
**Given** User set digest authentication to {} and {}|**Given** User set digest authentication to `username` and `password`
**Given** User set query parameters to|**Given** User set query parameters to<br>&emsp;&emsp;&#124;`key`&emsp;&emsp;&emsp;&emsp;&#124;`value`&emsp;&#124;<br>&emsp;&emsp;&#124;queryParam&nbsp;&nbsp;&nbsp;&#124;value1&emsp;&nbsp;&#124;<br>&emsp;&emsp;&#124;queryParam&nbsp;&nbsp;&nbsp;&#124;value2&emsp;&#124;
**Given** User set form parameters to|**Given** User set form parameters to<br>&emsp;&emsp;&#124;`key`&emsp;&emsp;&emsp;&emsp;&#124;`value`&emsp;&#124;<br>&emsp;&emsp;&#124;formParam&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#124;value1&emsp;&nbsp;&#124;<br>&emsp;&emsp;&#124;formParam&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#124;value2&emsp;&#124;
**Given** User set json body from the file {}|**Given** User set json body from the file `data/user`
**Given** User set json body from the template file {} with data {}|**Given** User set json body from the template file `data/template` with data `<data>`
**Given** User set json body to {}|**Given** User set json body to `{ "email": "eve.bolt@exe.in" }`

