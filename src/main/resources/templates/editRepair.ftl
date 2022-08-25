<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <style>
        input {
            display: block;
            font-size: 16px;
            font-weight: 700;
            color: #444;
            line-height: 1.3;
            padding: .6em 1.4em .5em .8em;
            width: 100%;
            max-width: 100%;
            box-sizing: border-box;
            margin: 0;
            border: 1px solid #aaa;
            box-shadow: 0 1px 0 1px rgba(0, 0, 0, .04);
            border-radius: .5em;
            background-color: #fff;
            background-position: right .7em top 50%, 0 0;
            background-size: .65em auto, 100%;
        }

        .select-css {
            cursor: pointer;
            display: block;
            font-size: 16px;
            font-family: sans-serif;
            font-weight: 700;
            color: #444;
            line-height: 1.3;
            padding: .6em 1.4em .5em .8em;
            width: 100%;
            max-width: 100%;
            box-sizing: border-box;
            margin: 0;
            border: 1px solid #aaa;
            box-shadow: 0 1px 0 1px rgba(0, 0, 0, .04);
            border-radius: .5em;
            -moz-appearance: none;
            -webkit-appearance: none;
            appearance: none;
            background-color: #fff;
            background-image: url('data:image/svg+xml;charset=US-ASCII,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%22292.4%22%20height%3D%22292.4%22%3E%3Cpath%20fill%3D%22%23007CB2%22%20d%3D%22M287%2069.4a17.6%2017.6%200%200%200-13-5.4H18.4c-5%200-9.3%201.8-12.9%205.4A17.6%2017.6%200%200%200%200%2082.2c0%205%201.8%209.3%205.4%2012.9l128%20127.9c3.6%203.6%207.8%205.4%2012.8%205.4s9.2-1.8%2012.8-5.4L287%2095c3.5-3.5%205.4-7.8%205.4-12.8%200-5-1.9-9.2-5.5-12.8z%22%2F%3E%3C%2Fsvg%3E'), linear-gradient(to bottom, #ffffff 0%, #e5e5e5 100%);
            background-repeat: no-repeat, repeat;
            background-position: right .7em top 50%, 0 0;
            background-size: .65em auto, 100%;
        }

        .select-css::-ms-expand {
            display: none;
        }

        .select-css:hover {
            border-color: #888;
        }

        .select-css:focus {
            border-color: #aaa;
            box-shadow: 0 0 1px 3px rgba(59, 153, 252, .7);
            box-shadow: 0 0 0 3px -moz-mac-focusring;
            color: #222;
            outline: none;
        }

        .select-css option {
            font-weight: normal;
        }

        *[dir="rtl"] .select-css, :root:lang(ar) .select-css, :root:lang(iw) .select-css {
            background-position: left .7em top 50%, 0 0;
            padding: .6em .8em .5em 1.4em;
        }

        a {
            color: #fff;
            text-decoration: none;
        }

        a:hover {
            color: white;
        }

        .link1:hover {
            color: #0d6efd;
            border-style: solid;
            border-width: 2px;
            border-color: #0d6efd;
            transition: color 0.3s, border 0.3s, border-width 0s;
            border-radius: 10px;
        }

        .btn-fake {
            --bs-btn-color: #fff;
            --bs-btn-bg: #373b3e;
            --bs-btn-border-color: #373b3e;
            --bs-btn-hover-color: #fff;
            --bs-btn-hover-bg: #424649;
            --bs-btn-hover-border-color: #373b3e;
            --bs-btn-focus-shadow-rgb: none;
            --bs-btn-active-color: #fff;
            --bs-btn-active-bg: #4d5154;
            --bs-btn-active-border-color: #373b3e;
            --bs-btn-active-shadow: none;
            --bs-btn-disabled-color: #fff;
            --bs-btn-disabled-bg: #373b3e;
            --bs-btn-disabled-border-color: #373b3e;
            border-radius: 0.375rem 0.375rem 0rem 0rem;
        }
    </style>
</head>
<body style="color:#fff; background-color:#212529">

<form action="" method="post">
    <fieldset>
        <table>
            <th></th>
            <th></th>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><input type="text" name="name" value=${item.name}><br></td>
            </tr>
            <tr>
                <td><label for="type">WorkTable:</label></td>
                <td align="left"><select name="workTable" class="select-css">
                        <#list worktables as worktable>
                            <option value=${worktable.id}> ${worktable.id} ${worktable.name}</option>
                        </#list>
                    </select></td>
            </tr>
            <tr>
                <td><label for="type">Type:</label></td>
                <td align="left"><select name="repairType" class="select-css">
                        <#list types as type>
                            <option value=${type.id}> ${type.id} ${type.name}</option>
                        </#list>
                    </select></td>
            </tr>
            <tr>
                <td><label for="name">Comment:</label></td>
                <td><input type="text" name="comment" value=${item.comment}><br></td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <button type="submit" class="btn btn-success">Edit</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>