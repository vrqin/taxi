<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script type="text/javascript">
    //	////console.info(sessionStorage.token);
    if (sessionStorage.token === "" || sessionStorage.token === undefined) {
        window.top.location = "http://localhost:8087/TaxiSMP/index.jsp";

    }
</script>