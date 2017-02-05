function selectRole() {
    var current = document.getElementById("id_r").value;
    $.ajax({
        type: "POST",
        url: "/selectRole",
        data: JSON.stringify({
            id_roles: current,
        }),
        contentType: 'application/json',
        mimeType: 'application/json',
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            templateSelect(data, current);
            for (var i = 0; i < data.length; i++) {
                if (data[i].id_roles == current)
                    $('#name_roles').val(data[i].name_roles);
            }

        }
    })
}
function changeRole() {
    if (document.getElementById("name_roles").value != "") {
        $.ajax({
            type: "POST",
            url: "/changeRole",
            data: JSON.stringify({
                id_roles: document.getElementById("id_r").value,
                name_roles: document.getElementById("name_roles").value
            }),

            dataType: "json",
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data, textStatus, jqXHR) {
                $('#name_roles').val("");
                templateSelect(data, 0);

            }
        })
    }
}
function addRole() {
    if (document.getElementById("name_roles").value != "") {
        $.ajax({
            type: "POST",
            url: "/addRole",
            data: JSON.stringify({name_roles: document.getElementById("name_roles").value}),
            dataType: "json",
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data, textStatus, jqXHR) {
                $('#name_roles').val("");
                templateSelect(data, 0);
            }
        })
    }
}
function deleteRole() {
    if (document.getElementById("name_roles").value != "") {
        $.ajax({
            type: "POST",
            url: "/deleteRole",
            data: JSON.stringify({id_roles: document.getElementById("id_r").value}),

            dataType: "json",
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data, textStatus, jqXHR) {
                $('#name_roles').val("");
                templateSelect(data, 0);
            }
        })
    }
}
function templateSelect(role, index) {
    var tmpl = document.getElementById('templateSelect').innerHTML.trim();
    tmpl = _.template(tmpl);
    document.getElementById('cont').innerHTML = tmpl({
        listRole: role,
        index: index
    });

}