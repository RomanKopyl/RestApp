<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout/>
        <span><a href="/user">User list</a></span>
    </div>
    <div>
        <form method="post">
            <input type="text" name="amount" placeholder="Enter the amount" />
            <input type="text" name="state" placeholder="Enter the state" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Add</button>
        </form>
    </div>
<#--    <div>-->
<#--        <form method="get" action="/main">-->
<#--            <input type="text" name="filter" value="${filter!''}">-->
<#--            <button type="submit">Найти</button>-->
<#--        </form>-->
<#--    </div>-->
    <div>List of transactions</div>
    <table>
        <tr>
            <th>Id</th>
            <th>Date</th>
            <th>Amount</th>
            <th>State</th>
            <th>Author</th>
        </tr>
        <#list transactions as transation>
            <tr>
                <td>${transation.id}</td>
                <td>${transation.date?string('dd.MM.yyyy HH:mm:ss')}</td>
                <td>${transation.amount!0}</td>
                <td>${transation.state!0}</td>
                <td>${transation.getAthorName()!'нема'}</td>
            </tr>
        <#else>
            No transaction
        </#list>
    </table>

<#--    UserList-->
<#--    <table>-->
<#--        <tr>-->
<#--            <th>Id</th>-->
<#--            <th>Username</th>-->
<#--            <th>State</th>-->
<#--        </tr>-->
<#--        <#list userList as user>-->
<#--            <tr>-->
<#--                <td>${user.id}</td>-->
<#--                <td>${user.name}</td>-->
<#--                <td>${user.state!0}</td>-->
<#--            </tr>-->
<#--        <#else>-->
<#--            No users-->
<#--        </#list>-->
<#--    </table>-->
</@c.page>