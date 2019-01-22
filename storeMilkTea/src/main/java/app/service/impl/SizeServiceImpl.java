package app.service.impl;

import app.bean.SizeInfo;
import app.model.Size;
import app.service.SizeService;
import app.util.ConvertModelToBean;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class SizeServiceImpl extends BaseServiceImpl implements SizeService {
    private static final Logger logger = Logger.getLogger(SizeServiceImpl.class);

    @Override
    public Size findById(Serializable key, boolean lock) {
        return null;
    }

    @Override
    public Size saveOrUpdate(Size entity) {
        return null;
    }

    @Override
    public boolean delete(Size entity) {
        return false;
    }

    @Override
    public List<SizeInfo> getSizes() {
        try {
            return ConvertModelToBean.mapSizesToSizeInfos(sizeDAO.getSizes());

        } catch (Exception e) {
            logger.error("Hibernate exception " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
