package app.service;

import app.bean.SizeInfo;
import app.model.Size;

import java.util.List;

public interface SizeService extends BaseService<Integer, Size> {
    List<SizeInfo> getSizes();
}
