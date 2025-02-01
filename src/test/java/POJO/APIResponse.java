package POJO;

import java.util.List;

public record APIResponse(int page, int per_page, int total, int total_pages, List<UserData> data, Support support) {}

