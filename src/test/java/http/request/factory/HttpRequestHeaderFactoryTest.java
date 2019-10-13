package http.request.factory;import http.HttpCookie;import http.request.HttpCookieStore;import http.request.HttpRequestHeader;import org.junit.jupiter.api.Test;import java.util.*;import static org.assertj.core.api.Assertions.assertThat;class HttpRequestHeaderFactoryTest {	@Test	void create_쿠키가_없는_경우() {		Map<String, String> map = new HashMap<>();		map.put("Host", "localhost:8080");		map.put("Connection", "keep-alive");		map.put("Content-Length", "345");		HttpRequestHeader httpRequestHeader = new HttpRequestHeader(map, new HttpCookieStore(Collections.EMPTY_LIST));		List<String> lines = Arrays.asList("Host: localhost:8080", "Connection: keep-alive", "Content-Length: 345");		assertThat(HttpRequestHeaderFactory.create(lines)).isEqualTo(httpRequestHeader);	}    @Test    void create_쿠키가_있는_경우() {        Map<String, String> map = new HashMap<>();        map.put("Host", "localhost:8080");        map.put("Connection", "keep-alive");        map.put("Content-Length", "345");        List<HttpCookie> cookies = Arrays.asList(new HttpCookie("logined", "false"), new HttpCookie("cart", "empty"));        HttpRequestHeader httpRequestHeader = new HttpRequestHeader(map, new HttpCookieStore(cookies));        List<String> lines = Arrays.asList("Host: localhost:8080", "Connection: keep-alive", "Content-Length: 345", "Cookie: logined=false;cart=empty");        assertThat(HttpRequestHeaderFactory.create(lines)).isEqualTo(httpRequestHeader);    }}