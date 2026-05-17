const Storage = (() => {
  const DRAFT_KEY = 'ideacheck_draft';
  const THEME_KEY = 'ideacheck_theme';

  function save(data) {
    try {
      localStorage.setItem(DRAFT_KEY, JSON.stringify(data));
    } catch (_) {}
  }

  function load() {
    try {
      const raw = localStorage.getItem(DRAFT_KEY);
      return raw ? JSON.parse(raw) : null;
    } catch (_) {
      return null;
    }
  }

  function clear() {
    try {
      localStorage.removeItem(DRAFT_KEY);
    } catch (_) {}
  }

  function saveTheme(theme) {
    try {
      localStorage.setItem(THEME_KEY, theme);
    } catch (_) {}
  }

  function loadTheme() {
    try {
      return localStorage.getItem(THEME_KEY) || 'light';
    } catch (_) {
      return 'light';
    }
  }

  return { save, load, clear, saveTheme, loadTheme };
})();
