    cleanObject(object = this.json) {
        Object.entries(object).forEach(([k, v]) => {
            if (v && typeof v === 'object') {
                this.cleanObject(v);
            }
            if (v && typeof v === 'object' && !Object.keys(v).length || v === null || v === undefined) {
                if (Array.isArray(object)) {
                    object.splice(k, 1);
                } else {
                    delete object[k];
                }
            }
        });
    }
