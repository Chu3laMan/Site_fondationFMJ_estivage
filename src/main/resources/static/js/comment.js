/**
 * halim zaaim
 */
function handleComment(event) {
    event.preventDefault();
    let comment = $("#commentForm #msg").val();
    let email = $("#commentForm #email").val();
    let name = $("#commentForm #name").val();
    if (comment.search("<script>") !== -1 || comment.search("</script>") !== -1) return;
    if (comment.length === 0 || email.length === 0 || name.length === 0) {
        $("commentForm #submit").prop("disabled", true);
        return;
    }
    let Htmlcomment = "<hr><li class=\"media\"> <a href=\"#\" class=\"pull-left\">" +
        "<img src=\"images/user.jpg\" alt=\"\" class=\"img-circle\"></a>" +
        "<div class=\"media-body\"> <span class=\"text-muted pull-right\">" +
        "<small class=\"text-muted\">" + email + "</small>" +
        "</span> <strong class=\"text-success\">" + name + "</strong><p>" +
        comment + "</p></div>" +
        "</li><hr>";

    $(".add-comment").append(Htmlcomment);


}